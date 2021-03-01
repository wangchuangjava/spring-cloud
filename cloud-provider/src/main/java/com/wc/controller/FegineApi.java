package com.wc.controller;
/**
 * 快递物流查询接口
 * 商品购买地址：https://market.aliyun.com/products/56928004/cmapi022273.html
 * String host = "http://kdwlcxf.market.alicloudapi.com"; //服务器
 * String path = "/kdwlcx"; //接口地址
 */


import com.wc.util.http.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

public class FegineApi {
    public static void main(String[] args) {
        String host = "http://kdwlcxf.market.alicloudapi.com";
        String path = "/kdwlcx";
        String method = "GET";
        System.out.println("请先替换成自己的AppCode");
        String appcode = "7219d139fd35462091953b671f8fb09e";  // !!! 替换这里填写你自己的AppCode 请在买家中心查看
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "APPCODE " + appcode); //格式为:Authorization:APPCODE 83359fd73fe11248385f570e3c139xxx
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("no", "549251918532");// !!! 请求参数
        querys.put("type", "ZTO");// !!! 请求参数
        try {
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            //System.out.println(response.toString()); //输出头部
            System.out.println(EntityUtils.toString(response.getEntity())); //输出json
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
