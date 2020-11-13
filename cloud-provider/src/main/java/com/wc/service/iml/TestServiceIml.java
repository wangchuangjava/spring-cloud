package com.wc.service.iml;

import com.wc.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: 王创
 * @time: 2020/11/13 15:14
 */
@Service
public class TestServiceIml implements TestService {
    @Override
    public String testOne() {
        return "hello world";
    }
}
