package org.example;
import io.reactivex.rxjava3.core.Observable;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class timer {
    public static void main(String[] args) {

        /*
        quand le delais passe, l'observable emit un onNext
        alors que dans interval on émet toutes les secondes
         */

        Observable<Long> timerObservable = Observable.timer(5, TimeUnit.SECONDS);

        timerObservable.subscribe( item -> {
            System.out.println("5 secondes have passed");
        });

        //pour eviter que le programme ne se ferme
        new Scanner(System.in).nextLine();



    }
}