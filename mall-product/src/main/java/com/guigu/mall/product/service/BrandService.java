package com.guigu.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.common.utils.PageUtils;
import com.guigu.mall.product.entity.BrandEntity;

import java.util.Map;

/**
 * 品牌
 *
 * @author jasper
 * @email timaxthu@gmail.com
 * @date 2024-11-01 15:44:34
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

