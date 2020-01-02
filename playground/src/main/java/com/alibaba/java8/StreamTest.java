package com.alibaba.java8;

import java.util.Arrays;
import static java.util.Comparator.comparing;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TransferQueue;
import java.util.stream.Collectors;

/**
 * StreamTest
 *
 * @author Frank Zhang
 * @date 2019-01-07 1:42 PM
 */
public class StreamTest {

    public static void main(String[] args) {
        //Prepare
        Trader frank = new Trader("Frank", "WuHu");
        Trader jack = new Trader("Jack", "HangZhou");
        Trader athony = new Trader("Athony", "WuHu");
        Trader lucy = new Trader("Lucy", "WuHu");

        List<Transaction> transactionList = Arrays.asList(
                new Transaction(frank, 2011, 300),
                new Transaction(frank, 2011, 800),
                new Transaction(athony, 2012, 400),
                new Transaction(jack, 2012, 700),
                new Transaction(jack, 2012, 650),
                new Transaction(lucy, 2011, 1200)
        );

        transactionList.stream()
                .filter(t -> {
                    System.out.println("filtering " + t.getTrader().getName());
                    return t.getYear() == 2012;
                })
                .map(t -> {
                    System.out.println("mapping " + t.getTrader().getName());
                    return t.getTrader();
                })
                .limit(2)
                .collect(Collectors.toList());

        //1、Find out the sum of 2011's transaction, sort by transaction amount
//        List<Transaction> first = transactionList.stream().filter(t -> t.getYear() == 2011).sorted(comparing(Transaction::getValue)).collect(Collectors.toList());
//        System.out.println(first);

/*        //2、交易员都在哪些不同的城市工作过?
        List<String> second = transactionList.stream().map(Transaction::getTrader).map(Trader::getCity).distinct().collect(Collectors.toList());
        System.out.println(second);

        //3、查找所有来自于芜湖的交易员，并按姓名排序
        List<Trader> third = transactionList.stream().map(Transaction::getTrader).filter(p -> p.getCity().equals("WuHu")).sorted(comparing(Trader::getName)).collect(Collectors.toList());
        System.out.println(third);

        //4、有没有交易员在HangZhou工作的
        boolean anyTraderInHZ = transactionList.stream().map(Transaction::getTrader).anyMatch(p -> p.getCity().equals("HangZhou"));
        System.out.println("is any trader in HZ : "+ anyTraderInHZ);

        //5、打印所有在芜湖交易员的交易额
        transactionList.stream().filter(p -> p.getTrader().getCity().equals("WuHu")).forEach(t -> System.out.println(t.getValue()));

        //6、所有交易中，交易额最高是多少
        Optional<Transaction> maxTransaction = transactionList.stream().max(comparing(Transaction::getValue));
        maxTransaction.get().setYear(2017);
        System.out.println(maxTransaction.get());

        //7、按照年份进行分组GroupingBy
        Map<Integer, List<Transaction>> transactionsByYear = transactionList.stream().collect(Collectors.groupingBy(Transaction::getYear));
        System.out.println(transactionsByYear);*/

    }
}
