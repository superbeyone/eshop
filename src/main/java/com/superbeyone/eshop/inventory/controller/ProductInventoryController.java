package com.superbeyone.eshop.inventory.controller;

import com.superbeyone.eshop.inventory.model.ProductInventory;
import com.superbeyone.eshop.inventory.request.ProductInventoryCacheRefreshRequest;
import com.superbeyone.eshop.inventory.request.ProductInventoryDBUpdateRequest;
import com.superbeyone.eshop.inventory.request.Request;
import com.superbeyone.eshop.inventory.service.ProductInventoryService;
import com.superbeyone.eshop.inventory.service.RequestAsyncProcessService;
import com.superbeyone.eshop.inventory.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr.superbeyone
 * @project eshop-inventory
 * @className ProductInventoryController
 * @description 商品库存Controller
 * @date 2019-03-06 09:53
 **/
@RestController
public class ProductInventoryController {

    @Autowired
    ProductInventoryService productInventoryService;

    @Autowired
    RequestAsyncProcessService requestAsyncProcessService;

    @RequestMapping("/updateProductInventory")
    public Response updateProductInventory(ProductInventory productInventory) {
        Response response = null;

        try {
            Request request = new ProductInventoryDBUpdateRequest(productInventory, productInventoryService);
            requestAsyncProcessService.process(request);
            response = new Response(Response.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            response = new Response(Response.FAILURE);
        }
        return response;
    }

    @RequestMapping("/getProductInventory")
    public ProductInventory getProductInventory(Integer productId) {
        ProductInventory productInventory = null;


        try {
            ProductInventoryCacheRefreshRequest request = new ProductInventoryCacheRefreshRequest(productId, productInventoryService, false);
            requestAsyncProcessService.process(request);

            long startTime = System.currentTimeMillis();
            long endTime = 0L;
            long waitTime = 0L;

            while (true) {
                if (waitTime > 200) {
                    break;
                }

                //尝试去redis中读取一次商品库存的缓存数据
                productInventory = productInventoryService.getProductInventoryCache(productId);

                //如果读取到了结果就返回
                if (productInventory != null) {
                    System.out.println("--------------------------->\t在200ms内读取到了redis中的库存缓存，商品id=" + productInventory.getProductId() + ", 商品库存数量=" + productInventory.getInventoryCnt());
                    return productInventory;
                } else {
                    //如果没有读取到结果
                    Thread.sleep(20);
                    endTime = System.currentTimeMillis();
                    waitTime = endTime - startTime;
                }
            }

            //直接尝试从数据库中读取数据
            productInventory = productInventoryService.findProductInventory(productId);
            if (productInventory != null) {
                //
                request = new ProductInventoryCacheRefreshRequest(productId, productInventoryService, true);
                requestAsyncProcessService.process(request);
                return productInventory;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ProductInventory(productId, -1L);
    }
}
