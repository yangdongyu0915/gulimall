package com.ydy.gulimall.product.dao;

import com.ydy.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author ydy
 * @email 1752510119@qq.com
 * @date 2024-01-30 21:41:36
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
