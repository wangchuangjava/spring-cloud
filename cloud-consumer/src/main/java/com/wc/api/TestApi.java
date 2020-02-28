package com.wc.api;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wc.fallback.TestFallbackFactory;
import com.wc.model.UserModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "provider01",fallbackFactory = TestFallbackFactory.class)
public interface TestApi {

    @RequestMapping("hello")
    List<UserModel> test01();

    //Feign默认集成了Ribbon，并和Eureka结合，默认实现了负载均衡的效果。
}
