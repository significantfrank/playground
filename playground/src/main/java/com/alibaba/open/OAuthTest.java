package com.alibaba.open;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * OAuthTest测试
 *
 * @author Frank Zhang
 * @date 2018-11-19 10:43 AM
 */
public class OAuthTest {

    public static void getToken(){
        String url = "https://oauth.taobao.com/token";
        Map<String, String> props = new HashMap<String, String>();
        props.put("grant_type", "authorization_code");
        /*测试时，需把test参数换成自己应用对应的值*/
        props.put("code", "test");
        props.put("client_id", "test");
        props.put("client_secret", "test");
        props.put("redirect_uri", "http://www.test.com");
        props.put("view", "web");
        String s = "";
    }

    public static void main(String[] args) throws Exception{
        /**
         * 1、申请appKey，secret
         *    1）正常流程是要走开放平台的开发者入驻（需要企业支付宝认证）
         *    2）为了绕过这个限制，我们开发了一个后门，https://activity.alibaba.com/pc/8a7691ba.html 可以直接申请appKey
         *    3）目前开放平台只支持havanaId登录，比如ICBU账号：aliqatest01，对应的淘宝id为：tbaliqatest
         */
        String appkey = "25265602"; //账号：tbaliqatest 对应的ICBU账号：aliqatest01
        String secret = "b6ae2ff0460a6e1d795a71ac65cea1c0";

        /**
         * 2、选择一个环境 http://open.taobao.com/doc.htm?docId=101617&docType=1  进行API调用
         */
        String url = "https://api.taobao.com/router/rest";//海外环境
        String sandboxUrl = "https://gw.api.tbsandbox.com/router/rest";//沙箱环境
        String productUrl = "https://eco.taobao.com/router/rest";//正式环境

        /**
         * 3、使用OAuth获取access_token，获取链接为：https://oauth.alibaba.com/authorize?response_type=token&client_id=25265602&sp=icbu
         *    注意这里的授权地址是https://oauth.alibaba.com，但是在文档中其地址是https://oauth.taobao.com，这个要区分开
         */

        /**
         * 4、下面是aliqatest07这个账号通过OAuth授权给client_id=25265602的token
         */
        String sessionKey = "50000801417cm4iudmUEypHachT9t1dcbf35b0WdkHwjvExWAlZ8tsBOukntQ28TIaI";

        /**
         * 5、使用这个token，就可以用SDK来调用client允许调用的API了，SDK封装了签名加密，响应解释，性能优化等
         */
//        TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
//        AlibabaProcurementMysupplierListRequest req = new AlibabaProcurementMysupplierListRequest();
//        req.setCurrentPage(20L);
//        req.setPageSize(10L);
//        req.setType("order");
//        AlibabaProcurementMysupplierListResponse rsp = client.execute(req, sessionKey);
//        System.out.println(rsp.getBody());
    }
}
