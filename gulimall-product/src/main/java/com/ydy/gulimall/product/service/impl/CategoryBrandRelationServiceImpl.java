package com.ydy.gulimall.product.service.impl;

import com.ydy.common.utils.PageUtils;
import com.ydy.common.utils.Query;
import com.ydy.gulimall.product.dao.BrandDao;
import com.ydy.gulimall.product.dao.CategoryBrandRelationDao;
import com.ydy.gulimall.product.dao.CategoryDao;
import com.ydy.gulimall.product.entity.BrandEntity;
import com.ydy.gulimall.product.entity.CategoryBrandRelationEntity;
import com.ydy.gulimall.product.entity.CategoryEntity;
import com.ydy.gulimall.product.service.CategoryBrandRelationService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("categoryBrandRelationService")
public class CategoryBrandRelationServiceImpl extends ServiceImpl<CategoryBrandRelationDao, CategoryBrandRelationEntity> implements CategoryBrandRelationService {

    @Resource
    private BrandDao brandDao;

    @Resource
    private CategoryDao categoryDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryBrandRelationEntity> page = this.page(
                new Query<CategoryBrandRelationEntity>().getPage(params),
                new QueryWrapper<CategoryBrandRelationEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryBrandRelationEntity> getBrandCateRelation(Long brandId) {
        List<CategoryBrandRelationEntity> relationEntityList = baseMapper.selectList(new QueryWrapper<CategoryBrandRelationEntity>().eq("brand_id", brandId));
        return relationEntityList;
    }

    /**
     * 保存 品牌和分类的id和名称
     *
     * @param categoryBrandRelation
     */
    @Transactional
    @Override
    public void saveIdAndName(CategoryBrandRelationEntity categoryBrandRelation) {
        Long brandId = categoryBrandRelation.getBrandId();
        Long catelogId = categoryBrandRelation.getCatelogId();
        BrandEntity brandEntity = brandDao.selectById(brandId);
        CategoryEntity categoryEntity = categoryDao.selectById(catelogId);
        categoryBrandRelation.setBrandName(brandEntity.getName());
        categoryBrandRelation.setCatelogName(categoryEntity.getName());
        baseMapper.insert(categoryBrandRelation);
    }

    /**
     * 根据catelogId获取品牌信息
     *
     * @param catId
     * @return
     */
    @Override
    public List<BrandEntity> getBrandByCatlogId(Long catId) {
        List<CategoryBrandRelationEntity> brandRelationEntityList = baseMapper.selectList(new QueryWrapper<CategoryBrandRelationEntity>()
                .eq("catelog_id", catId));
        List<Long> brandIds = brandRelationEntityList.stream().map(item -> {
            return item.getBrandId();
        }).collect(Collectors.toList());
        List<BrandEntity> brandEntityList = brandDao.selectBatchIds(brandIds);
        return brandEntityList;
    }
}