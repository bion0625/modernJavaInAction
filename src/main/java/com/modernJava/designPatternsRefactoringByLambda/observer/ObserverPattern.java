package com.modernJava.designPatternsRefactoringByLambda.observer;

public class ObserverPattern {
    public static void main(String[] args) {
        Feed f = new Feed();
        f.registerObserver(new NYTimes());
        f.registerObserver(new Guardian());
        f.registerObserver(new LeMonde());
        f.notifyObserver("The queen said her favourite book is Modern Java in Action!");

        FeedByLambda fl = new FeedByLambda();
        fl.registerObserver(tweet -> {
            if (tweet != null && tweet.contains("money")) {
                System.out.println(" Breaking news in NY! " + tweet);
            }
        });
        fl.registerObserver(tweet -> {
            if (tweet != null && tweet.contains("queen")) {
                System.out.println(" Yet more news from London... " + tweet);
            }
        });
        fl.notifyObserver("The queen said her favourite book is Modern Java in Action!");
    }
}
