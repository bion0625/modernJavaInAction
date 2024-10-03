package com.modernJava.streamUsing;

import java.util.*;

public class handsOnPractice {
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

        // 1. 2011년에 일어난 모든 트랜젝션을 찾아 값을 오름차순으로 정리하시오.
        // 2. 거래자가 근무하는 모든 도시를 중복없이 나열하시오.
        // 3. 케임브릿지에서 거래하는 모든 거래자를 찾아서 이름순으로 정렬하시오.
        // 4. 모든 거래자의 이름을 알파벳순으로 정렬해서 반환하시오.
        // 5. 밀라노에 거래자가 있는가?
        // 6. 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력하시오.
        // 7. 전체 트랜잭션 중 최댓값은 얼마인가?
        // 8. 전체 트랜잭션 중 최솟값은 얼마인가?

        List<Transaction> q1 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .toList();
        System.out.println("q1: " + q1);

        List<String> q2 = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .toList();
        System.out.println("q2: " + q2);

        List<Trader> q3 = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .toList();
        System.out.println("q3: " + q3);

        List<String> q4 = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .toList();
        System.out.println("q4: " + q4);

        String reQ4 = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);
        System.out.println("reQ4: " + reQ4);

        boolean q5 = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println("q5: " + q5);

        List<Integer> q6 = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .toList();
        System.out.println("q6: " + q6);

        transactions.stream()
                .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        int q7 = transactions.stream()
                .mapToInt(Transaction::getValue)
                .max().getAsInt();
        System.out.println("q7: " + q7);

        OptionalInt reQ7 = transactions.stream()
                .mapToInt(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println("reQ7: " + reQ7);

        int q8 = transactions.stream()
                .mapToInt(Transaction::getValue)
                .min().getAsInt();
        System.out.println("q8: " + q8);

        Optional<Transaction> reQ8 = transactions.stream()
                .reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
        System.out.println("reQ8: " + reQ8);

        Optional<Transaction> reReQ8 = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue));
        System.out.println("reReQ8: " + reReQ8);
    }
}
