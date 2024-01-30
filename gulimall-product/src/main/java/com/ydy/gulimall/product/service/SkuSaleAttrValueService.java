package com.ydy.gulimall.product.service;

import com.ydy.common.utils.PageUtils;
import com.ydy.gulimall.product.entity.SkuSaleAttrValueEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * sku销售属性&值
 *
 * @author huanglin
 * @email 2465652971@qq.com
 * @date 2020-07-16 15:28:09
 */
public interface SkuSaleAttrValueService extends IService<SkuSaleAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

