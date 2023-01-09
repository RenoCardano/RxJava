package org.example.coldHot;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.example.flowable.Item;


import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class coldHot {

    /*
    Un cold Observable est un Observable qui ne commence à produire des éléments que lorsqu'un abonné s'abonne à lui. Cela signifie que chaque abonné obtient sa propre copie des éléments produits par l'Observable,
    même s'il s'abonne après le début de la production d'éléments.
    Cela permet à chaque abonné de recevoir la série complète d'éléments produits par l'Observable, même s'il s'abonne tardivement.
    En comparaison, un hot Observable commence à produire des éléments indépendamment
    de tout abonné et chaque abonné reçoit les éléments produits à partir du moment où il s'abonne.
    Les abonnés qui s'abonnent tardivement ne recevront pas les éléments produits avant leur abonnement.
     */

    public static void main(String[] args) throws InterruptedException {
        //coldObservableExample();
        hotObservableExample();
    }

    private static void hotObservableExample() throws InterruptedException {

        /*
            La classe ConnectableObservable dans RxJava est un Observable qui ne commence
            à produire des éléments que lorsqu'une méthode de connexion est appelée sur lui.
            Cela permet de contrôler le moment où les éléments sont produits et envoyés aux abonnés.
            Pour utiliser un ConnectableObservable, vous devez d'abord vous abonner à lui comme vous le feriez
            avec n'importe quel autre Observable. Cependant, au lieu de déclencher la production d'éléments immédiatement,
            l'Observable attend que la méthode de connexion soit appelée. Lorsque la méthode de connexion est appelée,
            l'Observable commence à produire et à envoyer des éléments aux abonnés.
            Cela permet de synchroniser plusieurs Observables de manière à ce qu'ils produisent des éléments en même temps.
         */

        ConnectableObservable observable = Observable.interval(1, TimeUnit.SECONDS)
                .publish();

        //ConnectableObservable néccessite la méthode connect pour envoyer les items
        observable.connect();

        observable.subscribe(item -> {
            System.out.println( "Abonnée 1" + item);
        });

        Thread.sleep(5000);

        observable.subscribe(item -> {
            System.out.println( "Abonnée 2" + item);
        });


        Thread.sleep(10000000);


    }

    private static void coldObservableExample() {

        /*
        le coldObserver permet à la personne qui s'abonne de recevoir les données
        depuis le début à l'inverse le Hot prend les données dans l'état au momment
        de sa souscription
         */

        Observable<String> observable = Observable.just("a", "b", "c");

        observable.subscribe((item -> System.out.println("Observer 1 - " + item)));
        observable.subscribe((item -> System.out.println("Observer 2 - " + item)));
        observable.subscribe((item -> System.out.println("Observer 3 - " + item)));

    }


}

