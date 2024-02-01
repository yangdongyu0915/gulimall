package com.ydy.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ydy.common.utils.PageUtils;
import com.ydy.gulimall.coupon.entity.CouponEntity;

import java.util.Map;

/**
 * 优惠券信息
 *
 * @author ydy
 * @email 1752510119@qq.com
 * @date 2024-01-30 21:50:01
 */
public interface CouponService extends IService<CouponEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

