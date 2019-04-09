package com.alibaba.craftsman.book;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * MiddleVirable
 *
 * @author Frank Zhang
 * @date 2018-09-14 5:03 PM
 */
public class MiddleVirable {

    public static void main(String[] args) {
        testGroup();
    }

    public static void testFind(){
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher("hello abc bbc cbc ccc");
        //find向前迭代
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }

    public static void testGroup(){
        Pattern pattern = Pattern.compile("(\\w+)\\s\\d+");
        Matcher matcher = pattern.matcher("hello 123 abc bbc cbc ccc");
        matcher.find();
        System.out.println(matcher.group(1));
        System.out.println(matcher.group(0));
        System.out.println(matcher.group());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            //LOGGER.error(e);
        }
    }

    public static void header(){
        Pattern headerPattern = Pattern.compile("(\\w+)\\s\\d+");
        String line = "abc";
        Map headers = new HashMap();

        Matcher matcher = headerPattern.matcher(line);
        if(matcher.find()){
            headers.put(matcher.group(1), matcher.group(2));
        }

        if(matcher.find()){
            String key = matcher.group(1);
            String value = matcher.group(2);
            headers.put(key, value);
        }
    }
}
