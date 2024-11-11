package com.guigu.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.common.utils.PageUtils;
import com.guigu.mall.product.entity.SpuInfoEntity;

import java.util.Map;

/**
 * spu信息
 *
 * @author jasper
 * @email timaxthu@gmail.com
 * @date 2024-11-11 15:05:55
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

