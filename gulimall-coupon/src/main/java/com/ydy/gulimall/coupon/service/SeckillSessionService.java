package com.ydy.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ydy.common.utils.PageUtils;
import com.ydy.gulimall.coupon.entity.SeckillSessionEntity;

import java.util.Map;

/**
 * 秒杀活动场次
 *
 * @author ydy
 * @email 1752510119@qq.com
 * @date 2024-01-30 21:50:01
 */
public interface SeckillSessionService extends IService<SeckillSessionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

