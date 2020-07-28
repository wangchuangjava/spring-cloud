package com.wc.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: 王创
 * @time: 2020/7/28 9:41
 */
public class LeetCodeTest {
//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
//
//
//
// 示例:
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
//
// Related Topics 数组 哈希表
// 👍 8753 👎 0

    public static void main(String[] args) {
        //目标值
        int i = 18;
        Integer nums[] = {2, 7, 11, 15};
        List<Integer> list = Arrays.asList(nums);
        List<Integer> newList = new ArrayList<>();
        //两次循环比较放入新的集合当中
        for (Integer integer : list) {
            for (Integer integer1 : list) {
                if (integer1 == i - integer) {
                    newList.add(integer1);
                }
            }
        }
        for (Integer integer : newList) {
            int index = list.indexOf(integer);
            System.out.println("下标：" + index + "值=" + integer);

        }
    }

}
