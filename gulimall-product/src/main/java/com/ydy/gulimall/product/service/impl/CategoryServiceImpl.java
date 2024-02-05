package com.ydy.gulimall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ydy.common.utils.PageUtils;
import com.ydy.common.utils.Query;

import com.ydy.gulimall.product.dao.CategoryDao;
import com.ydy.gulimall.product.entity.CategoryEntity;
import com.ydy.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(new Query<CategoryEntity>().getPage(params), new QueryWrapper<CategoryEntity>());

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        //1.查出所有分类
        List<CategoryEntity> entities = baseMapper.selectList(null);
        //2.组装成父子的树状结构
        List<CategoryEntity> level1Menus = entities.stream().filter(item -> item.getParentCid() == 0).map(menu -> {
            menu.setChildren(getChildrens(menu, entities));
            return menu;
        }).sorted(Comparator.comparingInt(CategoryEntity::getSort)).collect(Collectors.toList());
        return level1Menus;
    }

    @Override
    public void removeMenuByIds(List<Long> list) {
        //TODO
        baseMapper.deleteBatchIds(list);
    }


    private List<CategoryEntity> getChildrens(CategoryEntity root, List<CategoryEntity> all) {
        List<CategoryEntity> children = all.stream().filter(categoryEntity -> categoryEntity.getParentCid() == root.getCatId()).map(categoryEntity -> {
            categoryEntity.setChildren(getChildrens(categoryEntity, all));
            return categoryEntity;
        }).sorted(Comparator.comparingInt(menu -> (menu.getSort() == null ? 0 : menu.getSort()))).collect(Collectors.toList());
        return children;
    }
}