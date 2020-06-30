package com.wc.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @Author 王创
 * @Description 算法工具类
 * @Date 10:39 2020/6/30
 **/
public final class DoubleUtil {
    /**
     * 默认除法运算精度
     */
    private static final Integer DEF_DIV_SCALE = 2;

    /**
     * 提供精确的加法运算
     *
     * @param value1 被加数
     * @param value2 加数
     * @return java.lang.Double 两个参数的和
     * @description 提供精确的加法运算
     * @methodname add
     * @author xukun
     * @date 2020/3/11 10:01
     */
    public static Double add(Double value1, Double value2) {
        BigDecimal b1 = BigDecimal.valueOf(value1);
        BigDecimal b2 = BigDecimal.valueOf(value2);
        return b1.add(b2).doubleValue();
    }


    /**
     * 提供精确的减法运算
     *
     * @param value1 被减数
     * @param value2 减数
     * @return double 两个参数的差
     * @description 提供精确的减法运算
     * @methodname sub
     * @author xukun
     * @date 2020/3/11 10:02
     */
    public static double sub(Double value1, Double value2) {
        BigDecimal b1 = BigDecimal.valueOf(value1);
        BigDecimal b2 = BigDecimal.valueOf(value2);
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 提供精确的乘法运算
     *
     * @param value1 被乘数
     * @param value2 乘数
     * @return java.lang.Double 两个参数的积
     * @description 提供精确的乘法运算
     * @methodname mul
     * @author xukun
     * @date 2020/3/11 10:04
     */
    public static Double mul(Double value1, Double value2) {
        BigDecimal b1 = BigDecimal.valueOf(value1);
        BigDecimal b2 = BigDecimal.valueOf(value2);
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 提供（相对）精确的除法运算，
     * 当发生除不尽的情况时， 精确到小数点以后2位，以后的数字四舍五入。
     *
     * @param dividend 被除数
     * @param divisor  除数
     * @return java.lang.Double 两个参数的商
     * @description
     * @methodname divide
     * @author xukun
     * @date 2020/3/11 10:05
     */
    public static Double divide(Double dividend, Double divisor) {
        return divide(dividend, divisor, DEF_DIV_SCALE);
    }

    /**
     * 提供（相对）精确的除法运算。 当发生除不尽的情况时，
     * 由scale参数指定精度，以后的数字四舍五入。
     *
     * @param dividend 被除数
     * @param divisor  除数
     * @param scale    表示表示需要精确到小数点以后几位
     * @return java.lang.Double 两个参数的商
     * @description
     * @methodname divide
     * @author xukun
     * @date 2020/3/11 10:07
     */
    public static Double divide(Double dividend, Double divisor, Integer scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = BigDecimal.valueOf(dividend);
        BigDecimal b2 = BigDecimal.valueOf(divisor);
        return b1.divide(b2, scale, RoundingMode.HALF_UP).doubleValue();
    }

    /**
     * 提供指定数值的（精确）小数位四舍五入处理。
     *
     * @param value 需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return double 四舍五入后的结果
     * @description
     * @methodname round
     * @author xukun
     * @date 2020/3/11 10:08
     */
    public static double round(double value, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b = BigDecimal.valueOf(value);
        BigDecimal one = BigDecimal.valueOf(1L);
        return b.divide(one, scale, RoundingMode.HALF_UP).doubleValue();
    }

}
