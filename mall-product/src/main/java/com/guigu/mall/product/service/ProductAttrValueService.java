package com.guigu.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.common.utils.PageUtils;
import com.guigu.mall.product.entity.ProductAttrValueEntity;

import java.util.Map;

/**
 * spu属性值
 *
 * @author jasper
 * @email timaxthu@gmail.com
 * @date 2024-11-11 15:05:56
 */
public interface ProductAttrValueService extends IService<ProductAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

