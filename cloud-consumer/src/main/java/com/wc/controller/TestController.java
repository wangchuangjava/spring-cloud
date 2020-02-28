package com.wc.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wc.api.TestApi;
import com.wc.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    private TestApi testApi;

    @RequestMapping("to/consumer")
    public List<UserModel> test01() {
        return testApi.test01();
    }

}
