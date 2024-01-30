package com.ydy.gulimall.product.controller;

import com.ydy.common.utils.PageUtils;
import com.ydy.common.utils.R;
import com.ydy.gulimall.product.entity.AttrEntity;
import com.ydy.gulimall.product.entity.AttrGroupEntity;
import com.ydy.gulimall.product.entity.vo.AttrGroupAndAttrVo;
import com.ydy.gulimall.product.entity.vo.AttrGroupRelationVo;
import com.ydy.gulimall.product.service.AttrAttrgroupRelationService;
import com.ydy.gulimall.product.service.AttrGroupService;
import com.ydy.gulimall.product.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 属性分组
 *
 * @author huanglin
 * @email 2465652971@qq.com
 * @date 2020-07-16 15:28:09
 */
@Slf4j
@RestController
@RequestMapping("product/attrgroup")
public class AttrGroupController {
    @Autowired
    private AttrGroupService attrGroupService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AttrAttrgroupRelationService attrAttrgroupRelationService;

    /**
     * 获取分类下所有分组&关联属性
     */
    @GetMapping("/{catelogId}/withattr")
    public R getGroupAndAttr(@PathVariable("catelogId") Long catelogId) {
        List<AttrGroupAndAttrVo> attrGroupAndAttrVos = attrGroupService.getGroupAndAttr(catelogId);
        return R.ok().put("data", attrGroupAndAttrVos);
    }

    /**
     * 获取属性分组的关联的所有属性
     */
    @GetMapping("/{attrgroupId}/attr/relation")
    public R list(@PathVariable("attrgroupId") Long attrgroupId) {
        List<AttrEntity> attrList = attrGroupService.getAttrByAttrGroupId(attrgroupId);
        return R.ok().put("data", attrList);
    }

    /**
     * 删除属性与分组的关联关系
     */
    @PostMapping("/attr/relation/delete")
    public R deleteRelation(@RequestBody AttrGroupRelationVo[] attrGroupRelationVo) {
        attrGroupService.deleteRelation(attrGroupRelationVo);
        return R.ok();
    }

    /**
     * 获取属性分组没有关联的其他属性
     */
    @GetMapping("/{attrgroupId}/noattr/relation")
    public R getNoRelation(@PathVariable("attrgroupId") Long attrgroupId,
                           @RequestParam Map<String, Object> params) {
        PageUtils pageUtils = attrGroupService.getNoRelation(attrgroupId, params);
        return R.ok().put("page", pageUtils);
    }

    /**
     * 添加属性与分组关联关系
     */
    @PostMapping("/attr/relation")
    public R saveRelation(@RequestBody List<AttrGroupRelationVo> attrGroupRelationVos) {
        attrAttrgroupRelationService.saveGroupCateRelation(attrGroupRelationVos);
        return R.ok();
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = attrGroupService.queryPage(params);
        return R.ok().put("page", page);
    }

    /**
     * @param params
     * @return
     */
    @GetMapping("/list/{catelogId}")
    public R list(@RequestParam Map<String, Object> params,
                  @PathVariable("catelogId") Long catelogId) {
        PageUtils queryPage = attrGroupService.queryPageByCid(params, catelogId);
        return R.ok().put("page", queryPage);
    }

    /**
     * 信息
     */
    @GetMapping("/info/{attrGroupId}")
    public R info(@PathVariable("attrGroupId") Long attrGroupId) {
        AttrGroupEntity attrGroup = attrGroupService.getById(attrGroupId);
        Long catelogId = attrGroup.getCatelogId();
        Long[] categoryPath = categoryService.findCategoryPath(catelogId);
        attrGroup.setCatelogPath(categoryPath);
        log.info("分组信息为==========" + attrGroup);
        return R.ok().put("attrGroup", attrGroup);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AttrGroupEntity attrGroup) {
        attrGroupService.save(attrGroup);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody AttrGroupEntity attrGroup) {
        attrGroupService.updateById(attrGroup);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] attrGroupIds) {
        attrGroupService.removeByIds(Arrays.asList(attrGroupIds));

        return R.ok();
    }

}
