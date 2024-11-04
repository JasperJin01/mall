package com.guigu.mall.member.dao;

import com.guigu.mall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author jasper
 * @email timaxthu@gmail.com
 * @date 2024-11-04 20:24:28
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
