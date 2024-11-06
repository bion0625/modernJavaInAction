package com.modernJava.declarativeProgramming;

import com.modernJava.streamUsing.Trader;
import com.modernJava.streamUsing.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {
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

        Transaction mostExpensive1 = transactions.get(0);
        if (mostExpensive1 == null)
            throw new IllegalStateException("Empty list of transactions");

        for (Transaction t : transactions.subList(1, transactions.size())) {
            if (t.getValue() > mostExpensive1.getValue()) mostExpensive1 = t;
        }

        System.out.println("mostExpensive1: " + mostExpensive1);

        Optional<Transaction> mostExpensive2 = transactions.stream()
                .max(Comparator.comparing(Transaction::getValue));

        System.out.println("mostExpensive2: " + mostExpensive2.orElseThrow());
    }
}
