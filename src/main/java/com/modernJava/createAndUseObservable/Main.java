package com.modernJava.createAndUseObservable;

import com.modernJava.firstReactiveApplication.TempInfo;
import io.reactivex.Observable;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Observable<String> strings = Observable.just("first", "second");

        Observable<Long> onePerSec = Observable.interval(1, TimeUnit.SECONDS);
//        onePerSec.subscribe(i -> System.out.println(TempInfo.fetch("New York")));
//        onePerSec.blockingSubscribe(i -> System.out.println(TempInfo.fetch("New York")));

//        Observable<TempInfo> observable = getTemperature("New York");
//        Observable<TempInfo> observable = getCelsiusTemperature("New York");
//        Observable<TempInfo> observable = getNegativeTemperature("New York");

        Observable<TempInfo> observable = getCelsiusTemperatures("New York", "Chicago", "San Francisco");
        observable.blockingSubscribe(new TempObserver());
    }

    public static Observable<TempInfo> getTemperature(String town) {
        return Observable.create(emitter -> Observable.interval(1, TimeUnit.SECONDS).subscribe(i -> {
            if (!emitter.isDisposed()) {
                if (i >= 5) {
                    emitter.onComplete();
                } else {
                    try {
                        emitter.onNext(TempInfo.fetch(town));
                    } catch (Exception e) {
                        emitter.onError(e);
                    }
                }
            }
        }));
    }

    public static Observable<TempInfo> getCelsiusTemperature(String town) {
        return getTemperature(town)
                .map(temp -> new TempInfo(temp.getTown(),
                        (temp.getTemp() - 32) * 5 / 9));
    }

    public static Observable<TempInfo> getCelsiusTemperatures(String... towns) {
        return Observable.merge(Arrays.stream(towns)
                .map(Main::getCelsiusTemperature)
                .collect(Collectors.toList()));
    }

    public static Observable<TempInfo> getNegativeTemperature(String town) {
        return getTemperature(town)
                .filter(temp -> temp.getTemp() < 0);
    }
}
