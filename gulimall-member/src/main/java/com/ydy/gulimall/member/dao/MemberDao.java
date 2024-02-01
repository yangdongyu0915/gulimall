package com.ydy.gulimall.member.dao;

import com.ydy.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author ydy
 * @email 1752510119@qq.com
 * @date 2024-01-31 16:59:00
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
