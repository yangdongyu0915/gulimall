package com.ydy.gulimall.product.service;

import com.ydy.common.utils.PageUtils;
import com.ydy.gulimall.product.entity.SpuInfoEntity;
import com.ydy.gulimall.product.entity.vo.SpuSaveVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * spu信息
 *
 * @author huanglin
 * @email 2465652971@qq.com
 * @date 2020-07-16 15:28:09
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveSpuInfo(SpuSaveVo spuSaveVo);

    PageUtils queryByCondition(Map<String, Object> params);
}

