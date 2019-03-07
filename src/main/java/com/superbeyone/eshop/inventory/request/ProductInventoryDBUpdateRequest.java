package com.superbeyone.eshop.inventory.request;

import com.superbeyone.eshop.inventory.model.ProductInventory;
import com.superbeyone.eshop.inventory.service.ProductInventoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Mr.superbeyone
 * @project eshop-inventory
 * @className ProductInventoryDBUpdateRequest
 * @description 商品库存数据库更新请求
 * @date 2019-03-06 08:49
 **/
public class ProductInventoryDBUpdateRequest implements Request {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private ProductInventory productInventory;

    private ProductInventoryService productInventoryService;

    public ProductInventoryDBUpdateRequest(ProductInventory productInventory, ProductInventoryService productInventoryService) {
        this.productInventory = productInventory;
        this.productInventoryService = productInventoryService;
    }

    /**
     * 处理请求
     */
    @Override
    public void process() {

        logger.debug("数据库更新请求开始执行，商品Id={}", productInventory.getProductId());
        //删除redis中的缓存
        productInventoryService.removeProductInventoryCache(productInventory);
        logger.debug("删除redis缓存");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //修改数据库中的库存数据
        productInventoryService.updateProductInventory(productInventory);
        logger.debug("更新redis缓存");
    }

    @Override
    public Integer getProductId() {
        return productInventory.getProductId();
    }

    @Override
    public boolean isForceRefresh() {
        return false;
    }
}
