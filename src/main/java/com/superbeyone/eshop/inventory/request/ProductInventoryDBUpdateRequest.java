package com.superbeyone.eshop.inventory.request;

import com.superbeyone.eshop.inventory.model.ProductInventory;
import com.superbeyone.eshop.inventory.service.ProductInventoryService;
import lombok.AllArgsConstructor;

/**
 * @author Mr.superbeyone
 * @project eshop-inventory
 * @className ProductInventoryDBUpdateRequest
 * @description 商品库存数据库更新请求
 * @date 2019-03-06 08:49
 **/
@AllArgsConstructor
public class ProductInventoryDBUpdateRequest implements Request {

    private ProductInventory productInventory;

    private ProductInventoryService productInventoryService;


    /**
     * 处理请求
     */
    @Override
    public void process() {
        //删除redis中的缓存
        productInventoryService.removeProductInventoryCache(productInventory);

        //修改数据库中的库存数据
        productInventoryService.updateProductInventory(productInventory);
    }

    @Override
    public Integer getProductId() {
        return productInventory.getProductId();
    }
}
