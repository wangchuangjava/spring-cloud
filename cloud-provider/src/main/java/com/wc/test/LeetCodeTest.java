package com.wc.test;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: 王创
 * @time: 2020/7/28 9:41
 */
public class LeetCodeTest {

    @Test
    public void testOne() {
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


    @Test
    public void testTwo() {
        //给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
        int x = 1230;
        if (x == 0) {
//            return 0;
            System.out.println(0);
        }
        if (x > (Math.pow(2, 31)) - 1 || x < (-1 * Math.pow(2, 31))) {
//            return 0;
            System.out.println(0);

        }
        long sum = 0;
        while (x != 0) {
            sum = sum * 10 + x % 10;
            System.out.println(sum);
            x = x / 10;
            System.out.println(x);
        }
        if (sum > (Math.pow(2, 31)) - 1 || sum < (-1 * Math.pow(2, 31))) {
//            return 0;
            System.out.println(0);

        } else {
//            return (int) sum;
            System.out.println(sum);

        }
    }

    @Test
    public void onlyRead() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        //修改为只读
        Collection<Integer> integers = Collections.unmodifiableCollection(list);
//        integers.add(2);
        System.out.println(integers);
    }

    @Test
    public void 冒泡排序() {
        int[] numbers = new int[]{100, 22, 33, 9999, 6, 66};
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int item = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = item;
                }
            }

        }
        for (int number : numbers) {
            System.out.println(number);
        }

    }

    @Test
    public void 迭代器遍历集合() {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next == 4) {
                iterator.remove();
            }
            System.out.println(next);
        }
        System.out.println(list.toString());
    }
}
