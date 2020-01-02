package com.alibaba.open;

/**
 * NoAuthTest
 *
 * @author Frank Zhang
 * @date 2018-11-19 10:42 AM
 */
public class NoAuthTest {

    public static void main(String[] args) throws Exception{
        String appkey = "25265602";
        String secret = "b6ae2ff0460a6e1d795a71ac65cea1c0";
        String url = "https://api.taobao.com/router/rest";//海外环境
        String sandboxUrl = "https://gw.api.tbsandbox.com/router/rest";//沙箱环境
        String productUrl = "https://eco.taobao.com/router/rest";//正式环境
//        TaobaoClient client = new DefaultTaobaoClient(productUrl, appkey, secret);
//        TimeGetRequest req = new TimeGetRequest();
//        TimeGetResponse rsp = client.execute(req);
//        System.out.println(rsp.getBody());
    }
}
