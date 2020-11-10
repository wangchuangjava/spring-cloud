package com.wc.test;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.wc.entity.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * guava练习
 */
public class GuavaDemo {
    /**
     * 集合抽取某个字段
     */
    @Test
    public void testOne() {
        User user = new User(1,2,"","");
        User user1 = new User(2222,2,"","");
        User user2 = new User(3333333,2,"","");
        List<User> userList=Lists.newArrayList();
        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        List<Integer> transform = Lists.transform(userList, User::getId);
        System.out.println(transform);
    }

    @Test
    public void testTwo() {
       List<Integer> list=Lists.newArrayList(1,2,1,2,3,3,3,4,4,6,6);
        Set<Integer> set= Sets.newHashSet(list);
        System.out.println(set);
    }

}
