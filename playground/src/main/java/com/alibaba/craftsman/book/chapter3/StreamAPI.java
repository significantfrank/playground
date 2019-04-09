package com.alibaba.craftsman.book.chapter3;

import com.alibaba.java8.Trader;
import com.alibaba.java8.Transaction;

import java.util.*;
import java.util.stream.Collectors;

/**
 * StreamAPI
 *
 * @author Frank Zhang
 * @date 2019-01-10 6:34 PM
 */
public class StreamAPI {

    public static void main(String[] args) {
        Trader frank = new Trader("Frank", "WuHu");
        Trader jack = new Trader("Jack", "HangZhou");
        Trader athony = new Trader("Athony", "WuHu");
        Trader lucy = new Trader("Lucy", "WuHu");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(frank, 2011, 300),
                new Transaction(frank, 2011, 800),
                new Transaction(athony, 2012, 400),
                new Transaction(jack, 2012, 700),
                new Transaction(jack, 2012, 650),
                new Transaction(lucy, 2011, 1200)
        );

        verbose(transactions);

        Map<Currency, List<Transaction>> transactionsByCurrencies =
                transactions.stream().filter(t -> t.getPrice() > 1000).collect(Collectors.groupingBy(Transaction::getCurrency));
    }

    private static void verbose(List<Transaction> transactions) {
        Map<Currency, List<Transaction>> transactionsByCurrencies = new HashMap<>();

        for (Transaction transaction : transactions){
            if(transaction.getPrice() > 1000){
                Currency currency = transaction.getCurrency();
                List<Transaction> transactionsForCurrency = transactionsByCurrencies.get(currency);
                if(transactionsForCurrency == null){
                    transactionsForCurrency = new ArrayList<>();
                    transactionsByCurrencies.put(currency, transactionsForCurrency);
                }
                transactionsForCurrency.add(transaction);
            }
        }
    }
}
