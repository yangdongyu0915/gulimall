package com.ydy.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ydy.common.utils.PageUtils;
import com.ydy.gulimall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author ydy
 * @email 1752510119@qq.com
 * @date 2024-01-30 21:41:36
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> listWithTree();
}

