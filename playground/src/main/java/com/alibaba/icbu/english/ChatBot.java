package com.alibaba.icbu.english;

import com.dingtalk.chatbot.DingtalkChatbotClient;
import com.dingtalk.chatbot.SendResult;
import com.dingtalk.chatbot.message.LinkMessage;
import com.dingtalk.chatbot.message.MarkdownMessage;

import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * ChatBot
 *
 * @author Frank Zhang
 * @date 2018-12-10 9:56 AM
 */
public class ChatBot {
    DingtalkChatbotClient client = new DingtalkChatbotClient();

    public static final String TEAM_INNER_WEB_HOOK = "https://oapi.dingtalk.com/robot/send?access_token=a0564bd363ffa47fe60f8ade7047c20de93db3f7b2ec9f074ea81d18d5a97c42";

    public static void main(String[] args) throws Exception{
        ChatBot chatBot = new ChatBot();
        chatBot.testSendMarkdownMessage();
    }

    public void testSendLinkMessage() throws Exception {
        LinkMessage message = new LinkMessage();
        message.setTitle("时代的火车向前开");
        message.setText("这个即将发布的新版本，创始人陈航（花名“无招”）称它为“红树林”。\n而在此之前，每当面临重大升级，产品经理们都会取一个应景的代号，这一次，为什么是“红树林”？\"");
        message.setMessageUrl("https://mp.weixin.qq.com/s?spm=a219a.7629140.0.0.EUDyWG&__biz=MzA4NjMwMTA2Ng==&mid=2650316842&idx=1&sn=60da3ea2b29f1dcc43a7c8e4a7c97a16&scene=2&srcid=09189AnRJEdIiWVaKltFzNTw&from=timeline&isappinstalled=0&key=&ascene=2&uin=&devicetype=android-23&version=26031933&nettype=WIFI");
        message.setPicUrl("https://img.alicdn.com/tps/TB1XLjqNVXXXXc4XVXXXXXXXXXX-170-64.png");
        SendResult result = this.client.send(TEAM_INNER_WEB_HOOK, message);
        System.out.println(result);
    }

    public void testSendLinkMessageWithoutIcon() throws Exception {
        LinkMessage message = new LinkMessage();
        message.setTitle("时代的火车向前开");
        message.setMessageUrl("https://mp.weixin.qq.com/s?spm=a219a.7629140.0.0.EUDyWG&__biz=MzA4NjMwMTA2Ng==&mid=2650316842&idx=1&sn=60da3ea2b29f1dcc43a7c8e4a7c97a16&scene=2&srcid=09189AnRJEdIiWVaKltFzNTw&from=timeline&isappinstalled=0&key=&ascene=2&uin=&devicetype=android-23&version=26031933&nettype=WIFI");
        message.setText("这个即将发布的新版本，创始人陈航（花名“无招”）称它为“红树林”。\n而在此之前，每当面临重大升级，产品经理们都会取一个应景的代号，这一次，为什么是“红树林”？\"");
        SendResult result = this.client.send(TEAM_INNER_WEB_HOOK, message);
        System.out.println(result);
    }

    public void testSendMarkdownMessage() throws Exception {
        MarkdownMessage message = new MarkdownMessage();
        message.setTitle("This is a markdown message");
        message.add(MarkdownMessage.getHeaderText(1, "header 1"));
        message.add(MarkdownMessage.getHeaderText(2, "header 2"));
        message.add(MarkdownMessage.getHeaderText(3, "header 3"));
        message.add(MarkdownMessage.getHeaderText(4, "header 4"));
        message.add(MarkdownMessage.getHeaderText(5, "header 5"));
        message.add(MarkdownMessage.getHeaderText(6, "header 6"));
        message.add(MarkdownMessage.getReferenceText("reference text"));
        message.add("\n\n");
        message.add("normal text");
        message.add("\n\n");
        message.add(MarkdownMessage.getBoldText("Bold Text"));
        message.add("\n\n");
        message.add(MarkdownMessage.getItalicText("Italic Text"));
        message.add("\n\n");
        ArrayList<String> orderList = new ArrayList();
        orderList.add("order item1");
        orderList.add("order item2");
        message.add(MarkdownMessage.getOrderListText(orderList));
        message.add("\n\n");
        ArrayList<String> unorderList = new ArrayList();
        unorderList.add("unorder item1");
        unorderList.add("unorder item2");
        message.add(MarkdownMessage.getUnorderListText(unorderList));
        message.add("\n\n");
        message.add(MarkdownMessage.getImageText("http://img01.taobaocdn.com/top/i1/LB1GCdYQXXXXXXtaFXXXXXXXXXX"));
        message.add(MarkdownMessage.getLinkText("This is a link", "dtmd://dingtalkclient/sendMessage?content=linkmessage"));
        message.add(MarkdownMessage.getLinkText("中文跳转", "dtmd://dingtalkclient/sendMessage?content=" + URLEncoder.encode("链接消息", "UTF-8")));
        SendResult result = this.client.send(TEAM_INNER_WEB_HOOK, message);
        System.out.println(result);
    }
}
