package com.ydy.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ydy.common.utils.PageUtils;
import com.ydy.gulimall.member.entity.MemberLevelEntity;

import java.util.Map;

/**
 * 会员等级
 *
 * @author ydy
 * @email 1752510119@qq.com
 * @date 2024-01-31 16:59:00
 */
public interface MemberLevelService extends IService<MemberLevelEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

