package com.wc.test.factory;

/**
 * @author Admin
 */
public class PhoneFactory {
    public Phone creatPhone(String type) {
        if ("小米".equals(type)) {
            return new XiaoMi();
        } else if ("华为".equals(type)) {
            return new HuaWei();

        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        PhoneFactory phoneFactory = new PhoneFactory();
        Phone phone = phoneFactory.creatPhone("华为");
        phone.creat();

    }

}
