package com.modernJava.collectionAPIRenewal;

import com.modernJava.streamUsing.Trader;
import com.modernJava.streamUsing.Transaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ListAndSet {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(brian, 2011, 300, "1"));
        transactions.add(new Transaction(raoul, 2012, 1000, "c"));
        transactions.add(new Transaction(raoul, 2011, 400, "3"));
        transactions.add(new Transaction(mario, 2012, 710, "d"));
        transactions.add(new Transaction(mario, 2012, 700, "4"));
        transactions.add(new Transaction(alan, 2012, 950, "a"));

        System.out.println("transactions: " + transactions);

//        for (Transaction transaction : transactions) {
//            if (Character.isDigit(transaction.getReferenceCode().charAt(0)))
//                transactions.remove(transaction);
//        }
//        System.out.println("transactions: " + transactions);

        for(Iterator<Transaction> iterator = transactions.iterator();iterator.hasNext();) {
            Transaction transaction = iterator.next();
            if (Character.isDigit(transaction.getReferenceCode().charAt(0)))
                iterator.remove();
        }
        System.out.println("transactions: " + transactions);

        transactions.removeIf(transaction ->
                !Character.isDigit(transaction.getReferenceCode().charAt(0)));
        System.out.println("transactions: " + transactions);

        List<String> referenceCodes = new ArrayList<>();
        referenceCodes.add("a12");
        referenceCodes.add("c14");
        referenceCodes.add("b13");
        System.out.println("referenceCodes: " + referenceCodes);

        referenceCodes.stream()
                .map(code -> Character.toUpperCase(code.charAt(0)) + code.substring(1))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("referenceCodes: " + referenceCodes);

        referenceCodes.replaceAll(code -> Character.toUpperCase(code.charAt(0)) + code.substring(1));
        System.out.println("referenceCodes: " + referenceCodes);
    }
}
