package com.guigu.mall.order.dao;

import com.guigu.mall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author jasper
 * @email timaxthu@gmail.com
 * @date 2024-11-04 20:15:07
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
