package com.superbeyone.eshop.inventory.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Mr.superbeyone
 * @project eshop-inventory
 * @className ProductInventory
 * @description 库存数量
 * @date 2019-03-06 08:32
 **/
@Data
@AllArgsConstructor
public class ProductInventory {

    private Integer productId;

    private long inventoryCnt;

}
