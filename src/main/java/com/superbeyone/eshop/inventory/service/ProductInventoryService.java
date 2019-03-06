package com.superbeyone.eshop.inventory.service;

import com.superbeyone.eshop.inventory.model.ProductInventory;

/**
 * @author Mr.superbeyone
 * @project eshop-inventory
 * @className ProductInventoryService
 * @description 商品库存
 * @date 2019-03-06 08:34
 **/

public interface ProductInventoryService {

    /**
     * 更新商品库存
     *
     * @param productInventory 商品库存
     */
    void updateProductInventory(ProductInventory productInventory);

    /**
     * 删除Redis中的商品库存缓存
     *
     * @param productInventory 商品库存
     */
    void removeProductInventoryCache(ProductInventory productInventory);

    /**
     * 根据商品Id查询商品库存
     *
     * @param productId 商品Id
     * @return
     */
    ProductInventory findProductInventory(Integer productId);

    /**
     * 设置商品库存的缓存
     *
     * @param productInventory 商品库存
     */
    void setProductInventoryCache(ProductInventory productInventory);

    /**
     * 从商品库存缓存中获取数据
     *
     * @param productId 商品id
     * @return
     */
    ProductInventory getProductInventoryCache(Integer productId);


}
