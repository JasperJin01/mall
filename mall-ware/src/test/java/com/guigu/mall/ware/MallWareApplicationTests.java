package com.guigu.mall.ware;

import com.guigu.mall.ware.entity.PurchaseEntity;
import com.guigu.mall.ware.service.PurchaseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MallWareApplicationTests {

    @Autowired
    PurchaseService purchaseService;


    @Test
    public void contextLoads() {
        PurchaseEntity purchase = new PurchaseEntity();
        purchase.setWareId(123L);
        purchase.setPhone("18945071576");
        purchaseService.save(purchase);
        System.out.println("保存成功");
    }

}
