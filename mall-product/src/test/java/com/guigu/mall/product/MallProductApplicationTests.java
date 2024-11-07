package com.guigu.mall.product;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guigu.mall.product.entity.BrandEntity;
import com.guigu.mall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

// 如果是Junit4 这里必须有 RunWith（之前老版本的Junit4确实是这样的，
// 但是我现在用的Junit4.12已经开始用import org.junit.jupiter.api.Test; 不加runwith好像也能跑）
@SpringBootTest
public class MallProductApplicationTests {
    // TODO 独特的颜色的注释
    // FIXME
    // NOTE 放假啊收款方久啊；考虑放假了；
    // VIS 阿里卡司法局；拉萨的地方久啊；了

    @Autowired
    BrandService brandService;

    // NOTE 这个test导包要注意一下，`import org.junit.Test;`, 不要导错了
    @Test
    public void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("time = " + time);

        brandEntity.setLogo("华为 " + time);
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
