package org.example;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Create {
    public static void main(String[] args) {

        Observable<String> observable = Observable.create(emitter -> {
            //permet d'emettre des evemenents
            //par défault ça ne fait rien il faut souscrire via subscribe
            emitter.onNext("Click 1");
            emitter.onNext("Click 2");
            //throw new RuntimeException("Something went bad");
            //notifier que l'on a terminé l'action
            emitter.onComplete();
        });
        observable.subscribe(item -> {
            System.out.println(item);
        }, throwable -> {
            //si une erreur apparaît
            System.out.println(throwable.getMessage());
        }, () -> {
            System.out.println("On completed");
        });

    }
}