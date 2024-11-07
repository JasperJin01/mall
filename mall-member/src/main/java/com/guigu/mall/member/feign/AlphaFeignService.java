package com.guigu.mall.member.feign;


import com.guigu.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

// 这是一个声明式的远程调用
@FeignClient("mall-coupon")
public interface AlphaFeignService {

    @RequestMapping("/coupon/coupon/member/list")
    public R membercoupons();

}
