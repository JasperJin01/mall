package com.guigu.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guigu.common.utils.PageUtils;
import com.guigu.mall.ware.entity.UndoLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author jasper
 * @email timaxthu@gmail.com
 * @date 2024-11-04 17:22:28
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}
