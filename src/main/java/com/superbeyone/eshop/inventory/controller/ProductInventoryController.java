package com.superbeyone.eshop.inventory.controller;

import com.superbeyone.eshop.inventory.model.ProductInventory;
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
    public Response updateProductInventory(ProductInventory productInventory){
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
    public ProductInventory getProductInventory(Integer productId){
        ProductInventory productInventory = null;


        return null;
    }
}
