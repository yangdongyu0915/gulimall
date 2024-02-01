package com.ydy.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ydy.common.utils.PageUtils;
import com.ydy.gulimall.product.entity.SkuSaleAttrValueEntity;

import java.util.Map;

/**
 * sku销售属性&值
 *
 * @author ydy
 * @email 1752510119@qq.com
 * @date 2024-01-30 21:41:35
 */
public interface SkuSaleAttrValueService extends IService<SkuSaleAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

