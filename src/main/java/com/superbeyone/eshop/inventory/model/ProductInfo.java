package com.superbeyone.eshop.inventory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mr.superbeyone
 * @project eshop-inventory
 * @className ProductInfo
 * @description 商品信息
 * @date 2019-03-08 17:31
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductInfo {

    private Long id;

    private String name;

    private Double price;
}
