package com.modernJava.streamCollectingData;


import com.modernJava.streamUsing.Trader;
import com.modernJava.streamUsing.Transaction;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollectingData {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        Map<Trader, List<Transaction>> transactionByTraders1
                = new HashMap<>();

        for (Transaction transaction : transactions) {
            Trader trader = transaction.getTrader();
            List<Transaction> transactionsForTrader
                    = transactionByTraders1.get(trader);
            if (transactionsForTrader == null) {
                transactionsForTrader = new ArrayList<>();
                transactionByTraders1.put(trader, transactionsForTrader);
            }
            transactionsForTrader.add(transaction);
        }
        System.out.println("transactionByTraders1: " + transactionByTraders1);

        Map<Trader, List<Transaction>> transactionByTraders2
                = transactions.stream().collect(Collectors.groupingBy(Transaction::getTrader));
        System.out.println("transactionByTraders2: " + transactionByTraders2);

        Stream<Transaction> transactionStream = transactions.stream();
        List<Transaction> transactions1 = transactionStream.collect(Collectors.toList());
        System.out.println("transactions1: " + transactions1);
    }
}
