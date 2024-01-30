package com.ydy.gulimall.product.service;

import com.ydy.common.utils.PageUtils;
import com.ydy.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author huanglin
 * @email 2465652971@qq.com
 * @date 2020-07-16 15:28:09
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> listWithTree();

    void removeMenus(List<Long> asList);

    Long[] findCategoryPath(Long catelogId);

}

