package com.guigu.mall.order;

import com.guigu.mall.order.entity.OrderItemEntity;
import com.guigu.mall.order.service.OrderItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
public class MallOrderApplicationTests {

    @Autowired
    OrderItemService orderItemService;

    @Test
    public void contextLoads() {
        OrderItemEntity orderItem = new OrderItemEntity();
        orderItem.setOrderSn("ordersntest");
        orderItem.setCategoryId(123L);
        orderItem.setSkuAttrsVals("SKP是啥啊");
        orderItemService.save(orderItem);
        System.out.println("保存完成");



    }

}
