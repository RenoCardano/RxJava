package org.example;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class range {
    public static void main(String[] args) {
        /*
        la methode range prendre deux parameters, le start et le counter
        c'est une methode reduce
        incrémente automatique à partir du start du nombre dans count
         */

        Observable<Integer> itemCounted = Observable.range(2, 5);

        itemCounted.subscribe(item -> {
           // System.out.print(item);
        });

    }
}