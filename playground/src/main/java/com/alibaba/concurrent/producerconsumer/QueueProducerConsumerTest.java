package com.alibaba.concurrent.producerconsumer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * QueueProducerConsumerTest
 *
 * @author Frank Zhang
 * @date 2018-05-02 1:50 PM
 */
public class QueueProducerConsumerTest {
    public static void main(String[] args) {
        SystemIn<String> sysQueue = new SystemIn(2000, 3);
        sysQueue.start();

        BufferedReader sysReader = new BufferedReader(new InputStreamReader(
                System.in));
        List<java.lang.String> elements = new ArrayList<>();
        try {
            String input = sysReader.readLine();
            while (!(input).equalsIgnoreCase("quit")) {
                StringTokenizer tokenizer = new StringTokenizer(input, ",");
                List<String> strList = new ArrayList<>();
                while (tokenizer.hasMoreElements()) {
                    strList.add(Thread.currentThread().getName() + " hello world " + tokenizer.nextToken());
                }

                sysQueue.addBatch(strList);

                input = sysReader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
