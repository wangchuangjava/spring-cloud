package com.wc.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AliPayConfig {

    public static String APPID = "2016101100657892";

    /** 私钥 pkcs8格式的 **/
    public static String RSA_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCm9L38VRWvx3QDPqe/ZTdt2NQtz+61cPM3ANVDsj+BdjGMS7Ne3n/RuqeVOEND6Z+s/RrA33lW3vDgKOn5nDwCvvOefuOtDoEb8jYZhIirraqOL8M81QAZSuQUk60c4lZXj4GsSMWf/5miFAkWV85+LNsKWxQtFm7UyZqv94DoRscAGwHuw+QXxfqKMOaXy4siaKSi00lD5jYv8GJBXqcx0a40A/DZAK/4fhMovKb55TfXtHGmtM9MC8E5tz40hiXXN6uPi7opaZe68QD1dnf9iqmL0Levp7TCCoJnbJMQXTuKeuAo2ECV0INgBPMfxjV1qHB0pccSUs3rH0lQ5AYrAgMBAAECggEAK07BGXtYrMgoJ89Q5Cz1O+FK6LdPTHGIJXRp3a2XG5X1NFdOqAU/UsAASIzXpf4sFUtybSWK7CXYhc0XJFCKoIu31h1EIdfpVb52mhfu+9mIrGlnU5hM9kKe91d3SE7N5tiq4m3eFarPx2M7GDier8wi5YTKrwdqqHfDUHH7VkTaHnwfcnYq2yP8jzIbs5Cv+fGkbeqWIipSj0edksUGJbLZ22DLdiOX+eJfEMW0o39SPnfWxd/urCdobzPrgn8SRGV4ICdTnEULZCZaGMcQ5Sm6ia4jHWRpJClzW4EqY6Ho9NyhzFlwLLMJrxBjf7AnbK61LsQrOMkKsqQdnRUUAQKBgQDhuqkVNfHh0PCF0QU0NYswWjbVYPugDPtveUglElKmwZuMNt6hlOhysnOSJRaRT2rhUBH/jBwll/TNRYjHpvuHsxqVxaqCd0NvOoQ430t5vW8Z4Mn7X/AdSzAPmaxIbFk6WVHN0wVOmwfZKevMMhy1EHDxo6sz2/W/ogd42a7EawKBgQC9WGKn9F5lxAUqtNqTlA9j5e0qdceyqP7xsodHBsVFjCVGCUX5gcoz6jUECfY8j0/3ZC9RP/YzOCeCQCIDhv9IMX1ku41QN723HvAe9YC+N4PF1Bi75Zb3WakQEE2ioeckoP5TIja/SiAmoDOd88BIqkZJAQa2b4XXxwCuHQ41QQKBgQDMrzkRHbh2/sKLZSzl2cOcFcHxHR8uU3dP7tcHnqTJx3en3j1koaViFAUOOYlMPIp7QuL/KeqAAFmgJXRRLk6ZD0SFGRdzdHf2jUZGV9yVyLvM6HPe+HC/72TmUH/TsEP8z++IxtfiHlwwhH3nzG0RlpYD11iwDr25hlBmOmXqfwKBgQCiZHu4sM2FWmlUB2ivyfypIToXgIyVnnuJsCR1tkjbLSeKuclaBQb3H5f4rtKRfhiHhVVPyhvOMgswmvCRNeccc9Wn33ODqUr9E3u+EbEpc1OBCDdub6ra2fs128W6BkHIGIwHoQBzb4/DkQK0Jap0qBU/57FqJpwURIlAy4q0AQKBgHaNTX3RHBCk6dchic107zvt4HwRplmSnL3A9mjO+xFeiazP9oGn1WVlU0qY8PxgdwcMoBb+V+V2YCvlP9vaVTEIsW6UEbMcMWqHnjOI6sIPNK9zH0O+BBvLboquIGcPd2H25T8BRj0mTmA8ctI1zkYOpcxUp84KAxUiQRHoFTPH";

    /** 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 **/
    public static String notify_url = "http://zk73yp.natappfree.cc/blade-demand/ali/pay/notify_url";

    /** 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址 **/
    public static String return_url = "http://zk73yp.natappfree.cc/blade-demand/ali/pay/return_url";

    /** 请求网关地址 **/
    public static String URL = "https://openapi.alipaydev.com/gateway.do";



    /** 编码 **/
    public static String CHARSET = "UTF-8";

    /** 返回格式 **/
    public static String FORMAT = "json";

    /** 支付宝公钥 **/
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxDi+DxiZSE7yYifaNdQxyWd8TT+ltdDGhx3mtnAfcW5jt8NbtUJgMU9bwmLugNV1hY/g6wf9yl7LPnOUpoRqYoqvpEwaNSNtJqEUO1I/lURpZiC+mAFcd4I7GdKNnFGgCyDUV/gVusSMmnUbqBzyNZtOj/6Gx1nQjpZIGcherFtSbDEmjBYhc2LRA0s8ESXEdpoQB2w5bo8V3FQSGPCOQozqqeW5hbcADJX6fGu0nfEC1m8Ot6Q/UcbMBpHIsXt92IMzJShvj+G4LJVL3oPjRNlE2TEK66bTMDOT3yxMi0D5J2VDWQGpqZNZdNrmL9jVWwJAfU1fzLkuAV+QWT7ioQIDAQAB";

    /** 日志记录目录 **/
    public static String log_path = "/log";

    /** RSA2 **/
    public static String SIGNTYPE = "RSA2";
}
