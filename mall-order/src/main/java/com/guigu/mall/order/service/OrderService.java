package com.guigu.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.common.utils.PageUtils;
import com.guigu.mall.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author jasper
 * @email timaxthu@gmail.com
 * @date 2024-11-04 20:15:07
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

