package com.guigu.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.common.utils.PageUtils;
import com.guigu.mall.product.entity.AttrEntity;

import java.util.Map;

/**
 * 商品属性
 *
 * @author jasper
 * @email timaxthu@gmail.com
 * @date 2024-11-11 15:05:56
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

