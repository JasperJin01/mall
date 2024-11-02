package com.guigu.mall.product;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guigu.mall.product.entity.BrandEntity;
import com.guigu.mall.product.service.BrandService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

// FIXME 这里必须有 RunWith
@RunWith(SpringRunner.class)
@SpringBootTest
public class MallProductApplicationTests {

    @Autowired
    BrandService brandService;

    // NOTE 这个test导包要注意一下，`import org.junit.Test;`, 不要导错了
    @Test
    public void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setLogo("华为");
        brandService.save(brandEntity);
        System.out.println("保存成功");
    }

    @Test
    public void test02() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setBrandId(6L);
        brandEntity.setDescript("华为无敌！华为天下第一");
        brandService.updateById(brandEntity);
    }

    @Test
    public void test03() {
        List<BrandEntity> list = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id", 6L));
        list.forEach((item)->{
            System.out.println(item);
        });
    }

}
