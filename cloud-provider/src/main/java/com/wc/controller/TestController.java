package com.wc.controller;

import com.wc.api.TestApi;
import com.wc.entity.User;
import com.wc.mapper.UserMapper;
import com.wc.model.UserModel;
import com.wc.util.EntityToModelUtil;
import org.springframework.beans.factory.NamedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController implements TestApi {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserModel> test01() {
        return EntityToModelUtil.entityToModel(userMapper.selectAll());
    }
}
