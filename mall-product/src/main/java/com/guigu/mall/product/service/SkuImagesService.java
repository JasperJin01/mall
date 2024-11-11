package com.guigu.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.common.utils.PageUtils;
import com.guigu.mall.product.entity.SkuImagesEntity;

import java.util.Map;

/**
 * sku图片
 *
 * @author jasper
 * @email timaxthu@gmail.com
 * @date 2024-11-11 15:05:55
 */
public interface SkuImagesService extends IService<SkuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

