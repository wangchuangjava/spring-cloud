package com.wc.fallback;

import com.wc.api.TestApi;
import com.wc.model.UserModel;
import feign.hystrix.FallbackFactory;
import lombok.SneakyThrows;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestFallbackFactory implements FallbackFactory<TestApi> {
    private static Log log = LogFactory.getLog(TestFallbackFactory.class);

    @Override
    public TestApi create(Throwable cause) {
        log.info("---------------------进入日志的打印方法：" + cause.getMessage());
        //第一种写法
//        TestApi testApi = new TestApi() {
//            @Override
//            public List<UserModel> test01() {
//                log.info("请求服务失败。。。。");
//                return null;
//            }
//        };
//        return testApi;

        //第二种写法
        return new TestApi() {
            @Override
            public List<UserModel> test01() {
                List<UserModel> list = new ArrayList<>();
                UserModel build = UserModel.builder().id(-1).build();
                list.add(build);
                return list;
            }
        };
    }
}
