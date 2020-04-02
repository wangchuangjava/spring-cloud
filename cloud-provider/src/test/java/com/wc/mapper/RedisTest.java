package com.wc.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wc.CloudProviderApplication;
import com.wc.entity.User;
import com.wc.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.RedisClientInfo;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

/**
 * 操作redis样例
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CloudProviderApplication.class)
public class RedisTest {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getString() {
        //存值
        redisTemplate.opsForValue().set("sex", "nv");
        //通过key取值
        Object name = redisTemplate.opsForValue().get("sex");

        System.out.println(name);
    }

    @Test
    public void utilTest() {
        List<User> list = null;
        if (redisTemplate.hasKey("user")) {
            list = (List<User>) redisTemplate.opsForValue().get("user");
            System.out.println("从缓存获取--------------------------------》");
            System.out.println(list);
        } else {
            System.out.println("从数据库查，并存redis--------------------------------》");
            redisTemplate.opsForValue().set("user", userMapper.selectAll());
        }
    }

    @Test
    public void hashTest() {
        if (redisTemplate.hasKey("user1")) {
            System.out.println("缓存中有值--------------------------------》");
//            Collection<Object> keys = new ArrayList<>();
//            keys.add("id");
//            keys.add("groupId");
//            keys.add("name");
//            keys.add("address");
            Map<Object, Object> entries = redisTemplate.opsForHash().entries("user1");
            Integer id = Integer.parseInt(entries.get("id").toString());
            Integer groupId =Integer.parseInt(entries.get("groupId").toString());
            String name = entries.get("name").toString();
            String address = entries.get("address").toString();
            User build = User.builder().id(id).groupId(groupId).name(name).address(address).build();
            System.out.println(build);
        } else {
            System.out.println("无缓存--------------------------------》");
            Map<String, String> data = new HashMap<>();
            User user = userMapper.selectByPrimaryKey(1);
            data.put("id", user.getId().toString());
            data.put("groupId", user.getGroupId().toString());
            data.put("name", user.getName());
            data.put("address", user.getAddress());
            redisTemplate.opsForHash().putAll("user1", data);
            System.out.println("缓存成功--------------------------------》");
        }


    }
}
