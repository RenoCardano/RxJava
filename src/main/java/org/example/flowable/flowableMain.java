package org.example.flowable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.Scanner;

import static java.lang.Thread.sleep;

public class flowableMain {
    /*
   La classe Flowable dans RxJava est un type de flux de données qui peut produire un nombre illimité
   d'éléments de manière asynchrone et gérer de manière efficace la pression sur les ressources.
   Elle a été conçue pour remplacer la classe Observable dans certaines situations où l'observable
   peut produire un nombre très élevé d'éléments, ce qui peut entraîner des problèmes de mémoire ou
   de performances. Flowable utilise une technique de diffusion en backpressure pour gérer cette surcharge
    de données de manière efficace.
    */
    public static void main(String[] args) {
        asyncFlowableExample();

    }

    private static void asyncFlowableExample() {

        Flowable.range(1, 1000000)
                .map(Item::new)
                .observeOn(Schedulers.io())
                .subscribe( item -> {
                    sleep(1000);
                    System.out.println("Received Item" + item.id);
                });
        try {
            sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

