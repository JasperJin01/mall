package com.guigu.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.common.utils.PageUtils;
import com.guigu.mall.product.entity.SkuInfoEntity;

import java.util.Map;

/**
 * sku信息
 *
 * @author jasper
 * @email timaxthu@gmail.com
 * @date 2024-11-11 15:05:55
 */
public interface SkuInfoService extends IService<SkuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

