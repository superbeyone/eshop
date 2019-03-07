package com.superbeyone.eshop.inventory.service.impl;

import com.superbeyone.eshop.inventory.mapper.ProductInventoryMapper;
import com.superbeyone.eshop.inventory.model.ProductInventory;
import com.superbeyone.eshop.inventory.persist.RedisDao;
import com.superbeyone.eshop.inventory.service.ProductInventoryService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Mr.superbeyone
 * @project eshop-inventory
 * @className ProductInventoryServiceImpl
 * @description
 * @date 2019-03-06 08:39
 **/
@Service
public class ProductInventoryServiceImpl implements ProductInventoryService {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    ProductInventoryMapper productInventoryMapper;

    @Autowired
    RedisDao redisDao;


    /**
     * 更新商品库存
     *
     * @param productInventory 商品库存
     */
    @Override
    public void updateProductInventory(ProductInventory productInventory) {
        productInventoryMapper.updateProductInventory(productInventory);
        logger.debug("修改数据库中的商品库存，商品Id={}，商品数量={}", productInventory.getProductId(), productInventory.getInventoryCnt());
    }

    /**
     * 删除Redis中的商品库存缓存
     *
     * @param productInventory 商品库存
     */
    @Override
    public void removeProductInventoryCache(ProductInventory productInventory) {
        String key = "product:inventory:" + productInventory.getProductId();
        redisDao.del(key);
    }

    /**
     * 根据商品Id查询商品库存
     *
     * @param productId 商品Id
     * @return
     */
    @Override
    public ProductInventory findProductInventory(Integer productId) {
        return productInventoryMapper.findProductInventory(productId);
    }

    /**
     * 设置商品库存的缓存
     *
     * @param productInventory 商品库存
     */
    @Override
    public void setProductInventoryCache(ProductInventory productInventory) {
        String key = "product:inventory:" + productInventory.getProductId();
        redisDao.set(key, String.valueOf(productInventory.getInventoryCnt()));
        logger.debug("已更新商品库存的缓存，商品Id={}", productInventory.getProductId());
    }

    /**
     * 从商品库存缓存中获取数据
     *
     * @param productId 商品id
     * @return
     */
    @Override
    public ProductInventory getProductInventoryCache(Integer productId) {
        long inventoryCnt = 0L;
        String key = "product:inventory:" + productId;
        String result = redisDao.get(key);
        logger.debug("从商品缓存中获取数据，key={}，result={}", key, result);
        if (StringUtils.isNotBlank(result)) {
            try {
                inventoryCnt = Long.valueOf(result);
                return new ProductInventory(productId, inventoryCnt);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


}
