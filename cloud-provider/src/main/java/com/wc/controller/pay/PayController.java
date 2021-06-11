package com.wc.controller.pay;


import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.alipay.api.response.AlipayTradeWapPayResponse;
import com.wc.config.AliPayConfig;

import lombok.AllArgsConstructor;
import org.apache.http.HttpResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/ali/pay")
public class PayController {

    /**
     * 支付
     */
    @PostMapping("/pay")
    public String pay() {
        try {
            // 商户订单号，商户网站订单系统中唯一订单号，必填
            String out_trade_no = "20210601";
            // 订单名称，必填
            String subject = "测试支付1";
            // 付款金额，必填
            String total_amount = "100";
            // 商品描述，可空
            String body = "苹果12";
            // 超时时间 可空
            String timeout_express = "2m";
            // 销售产品码 必填
            /**********************/
            // SDK 公共请求类，包含公共请求参数，以及封装了签名与验签，开发者无需关注签名与验签
            //调用RSA签名方式
            AlipayClient client = new DefaultAlipayClient(AliPayConfig.URL, AliPayConfig.APPID, AliPayConfig.RSA_PRIVATE_KEY, AliPayConfig.FORMAT, AliPayConfig.CHARSET, AliPayConfig.ALIPAY_PUBLIC_KEY, AliPayConfig.SIGNTYPE);
            AlipayTradePagePayRequest alipay_request = new AlipayTradePagePayRequest();


            // 封装请求支付信息
            AlipayTradeWapPayModel model = new AlipayTradeWapPayModel();
            model.setOutTradeNo(out_trade_no);
            model.setSubject(subject);
            model.setTotalAmount(total_amount);
            model.setBody(body);
            model.setTimeoutExpress(timeout_express);
            model.setProductCode("FAST_INSTANT_TRADE_PAY");
            alipay_request.setBizModel(model);
            // 设置异步通知地址
            alipay_request.setNotifyUrl(AliPayConfig.notify_url);
            // 设置同步地址
//            alipay_request.setReturnUrl(AliPayConfig.return_url);

            //3、请求支付宝进行付款，并获取支付结果
            AlipayTradePagePayResponse alipayTradePagePayResponse = client.pageExecute(alipay_request);
            String result = alipayTradePagePayResponse.getBody();
            return result;
        } catch (Exception ce) {
            System.err.println(ce.getMessage());
            return ce.getMessage();
        }
    }

    /**
     * 回调
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/notify_url")
    public String notify_url(HttpServletRequest request, HttpServletResponse response) {
        System.err.println("==================支付宝异步返回支付结果开始");
        //1.从支付宝回调的request域中取值
        //获取支付宝返回的参数集合
        Map<String, String[]> aliParams = request.getParameterMap();
        //用以存放转化后的参数集合
        Map<String, String> conversionParams = new HashMap<String, String>();
        for (Iterator<String> iter = aliParams.keySet().iterator(); iter.hasNext(); ) {
            String key = iter.next();
            String[] values = aliParams.get(key);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
            // valueStr = new String(valueStr.getBytes("ISO-8859-1"), "uft-8");
            conversionParams.put(key, valueStr);
        }
        System.err.println("==================返回参数集合：" + conversionParams);
        System.err.println(conversionParams);

        return "";
    }


}
