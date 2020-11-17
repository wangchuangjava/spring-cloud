package com.wc.test;

import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.wc.entity.User;
import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * guava练习
 */
public class GuavaDemo {
    /**
     * 集合抽取某个字段
     */
    @Test
    public void testOne() {
        User user = new User(1, 2, "", "");
        User user1 = new User(2222, 2, "", "");
        User user2 = new User(3333333, 2, "", "");
        List<User> userList = Lists.newArrayList();
        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        List<Integer> transform = Lists.transform(userList, User::getId);
        System.out.println(transform);
    }

    /**
     * @return void
     * @Author 王创
     * @Description 简单去重
     * @Date 8:58 2020/11/17
     * @Param []
     **/
    @Test
    public void testTwo() {
        List<Integer> list = Lists.newArrayList(1, 2, 1, 2, 3, 3, 3, 4, 4, 6, 6);
        Set<Integer> set = Sets.newHashSet(list);
        System.out.println(set);
    }

    /**
     * @return void
     * @Author 王创
     * @Description 计算代码运行的时间
     * @Date 9:03 2020/11/17
     * @Param []
     **/
    @Test
    public void testThree() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < 1000; i++) {
            //dosomething
        }
        long nanos = stopwatch.elapsed(TimeUnit.MILLISECONDS);
        System.out.println(nanos);


    }

    /**
     * @return void
     * @Author 王创
     * @Description 简单校验
     * @Date 9:44 2020/11/17
     * @Param []
     **/
    @Test
    public void checkDemo() {
        int count = -1;
        Preconditions.checkArgument(count > 0, "must be positive: %s", count);

    }
}
