package com.wc.util.guava;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Sets;

import java.util.List;

/**
 * 王创
 */
public class GuavaUtil {
    /**
     * @return java.lang.String
     * @Author 王创
     * @Description 集合转字符串拼接
     * @Date 13:19 2020/11/10
     * @Param [join, list]
     **/
    public static String listToString(String join, List<?> list) {
        return Joiner.on(join).join(list);
    }

    /**
     * @return java.util.List<java.lang.String>
     * @Author 王创
     * @Description 字符串拆分
     * @Date 13:29 2020/11/10
     * @Param [join, str]
     **/
    public static List<String> stringToList(String join, String str) {
        return Splitter.on(join).splitToList(str);
    }

    public static void 集合操作() {
//        //并集
//        Sets.SetView union = Sets.union(setA, setB);
//        //差集
//        Sets.SetView difference = Sets.difference(setA, setB);
//        //交集
//        Sets.SetView intersection = Sets.intersection(setA, setB);
    }
}
