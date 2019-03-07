package com.superbeyone.eshop.inventory.request;

import com.superbeyone.eshop.inventory.model.ProductInventory;
import com.superbeyone.eshop.inventory.service.ProductInventoryService;

/**
 * @author Mr.superbeyone
 * @project eshop-inventory
 * @className ProductInventoryCacheRefreshRequest
 * @description 重新加载商品库存的缓存
 * @date 2019-03-06 08:54
 **/
public class ProductInventoryCacheRefreshRequest implements Request {

    /**
     * 商品Id
     */
    private Integer productId;

    /**
     * 商品库存Service
     */
    private ProductInventoryService productInventoryService;

    /**
     * 是否强制刷新缓存
     */
    private boolean forceRefresh;

    public ProductInventoryCacheRefreshRequest(Integer productId, ProductInventoryService productInventoryService, boolean forceRefresh) {
        this.productId = productId;
        this.productInventoryService = productInventoryService;
        this.forceRefresh = false;
    }

    /**
     * 处理请求
     */
    @Override
    public void process() {
        //从数据库中查询出最新的商品库存信息
        ProductInventory productInventory = productInventoryService.findProductInventory(productId);
        //将最新的商品库存信息更新到redis缓存中
        productInventoryService.updateProductInventory(productInventory);
    }

    @Override
    public Integer getProductId() {
        return productId;
    }

    @Override
    public boolean isForceRefresh() {
        return forceRefresh;
    }
}
