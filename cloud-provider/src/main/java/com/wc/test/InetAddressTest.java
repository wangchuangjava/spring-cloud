package com.wc.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @description:
 * @author: 王创
 * @time: 2020/7/31 10:41
 */
public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        //基本的网络支持
        InetAddress byName = InetAddress.getByName("DESKTOP-HM76LOK");
        System.out.println(byName.getHostName());
    }
}
