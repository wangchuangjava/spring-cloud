package com.wc.util.bean;

import org.apache.commons.beanutils.BeanUtils;
import com.alibaba.fastjson.JSON;
import com.rits.cloning.Cloner;


import java.util.*;

/**
 * @description:
 * @author: 王创
 * @time: 2020/6/30 16:44
 */
public class BeanUtil {
    private static final Cloner cloner = new Cloner();

    /**
     * 复制对象（深度拷贝）
     *
     * @param object
     * @param <T>
     * @return
     */
    public static <T> T clone(final T object) {
        if (object == null) {
            return null;
        }
        return cloner.deepClone(object);
    }

    /**
     * 复制集合（深度拷贝）
     *
     * @param object
     * @param <T>
     * @return
     */
    public static <T> List<T> cloneList(final List<T> object) {
        if (object == null) {
            return null;
        }
        return cloner.deepClone(object);
    }

    /**
     * 复制对象到指定类（深度拷贝）
     *
     * @param object
     * @param destclas 指定类
     * @param <T>
     * @return
     */
    public static <T> T clone(final Object object, Class<T> destclas) {
        if (object == null) {
            return null;
        }
        String json = JSON.toJSONString(object);
        return JSON.parseObject(json, destclas);
    }

    /**
     * 复制集合到指定类（深度拷贝）
     *
     * @param object
     * @param destclas 指定类
     * @param <T>
     * @return
     */
    public static <T> List<T> cloneList(List<?> object, Class<T> destclas) {
        if (object == null) {
            return new ArrayList<T>();
        }
        String json = JSON.toJSONString(object);
        return JSON.parseArray(json, destclas);
    }

    /**
     * @return void
     * @Author 王创
     * @Description 实体互转测试
     * @Date 17:15 2020/6/30
     * @Param [args]
     **/
    public static void main(String[] args) {
        User user = new User("1", "www", "nv", "110");
        User user1 = new User("2", "www", "nv", "110");
        User user2 = new User("3", "www", "nv", "110");
        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        List<Mine> clone = BeanUtil.cloneList(userList, Mine.class);
        for (Mine mine : clone) {
            System.out.println(mine.getId());
        }
    }


}
