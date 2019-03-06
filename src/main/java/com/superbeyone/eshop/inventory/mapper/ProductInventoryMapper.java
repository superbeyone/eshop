package com.superbeyone.eshop.inventory.mapper;

import com.superbeyone.eshop.inventory.model.ProductInventory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author Mr.superbeyone
 * @project eshop-inventory
 * @className ProductInventoryMapper
 * @description 商品库存Mapper
 * @date 2019-03-06 08:40
 **/
@Component
public interface ProductInventoryMapper {

    /**
     * 更新商品库存
     * @param productInventory  商品库存
     */
    void updateProductInventory(ProductInventory productInventory);

    /**
     * 根据商品id查询商品库存信息
     * @param productId 商品id
     * @return
     */
    ProductInventory findProductInventory(@Param("productId") Integer productId);

}
