package org.example;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class interval {
    public static void main(String[] args) {


        Observable<Long> intervalObservable = Observable.interval(1, TimeUnit.SECONDS);

        intervalObservable.subscribe( item -> {
            System.out.println(item);
        });

        //pour eviter que le programme ne se ferme
       // new Scanner(System.in).nextLine();



    }
}