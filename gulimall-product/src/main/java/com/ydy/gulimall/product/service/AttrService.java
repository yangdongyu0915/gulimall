package com.ydy.gulimall.product.service;

import com.ydy.common.utils.PageUtils;
import com.ydy.gulimall.product.entity.AttrEntity;
import com.ydy.gulimall.product.entity.ProductAttrValueEntity;
import com.ydy.gulimall.product.entity.vo.AttrResVo;
import com.ydy.gulimall.product.entity.vo.AttrVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * 商品属性
 *
 * @author huanglin
 * @email 2465652971@qq.com
 * @date 2020-07-16 15:28:09
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryByCid(Map<String, Object> params, Long catelogId, String attrType);

    void saveVo(AttrVo attr);

    AttrResVo getAttrInfo(Long attrId);

    void updateVo(AttrVo attr);

    List<ProductAttrValueEntity> getSpuSpecification(Long spuId);

    void updateSpecification(Long spuId, List<ProductAttrValueEntity> productAttrValueEntities);

}

