package com.guigu.mall.product.dao;

import com.guigu.mall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author jasper
 * @email timaxthu@gmail.com
 * @date 2024-11-01 15:44:34
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
