package org.example;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;

public class CompletableFunction {

    public static void main(String[] args) {

        /*
        La classe Completable dans RxJava est un type de flux de données qui ne produit aucun élément,
        mais indique simplement la fin de son exécution avec un succès ou une erreur.
        Elle peut être utilisée pour représenter une opération qui ne retourne pas de valeur,
        mais qui déclenche une action ou un traitement lorsqu'elle est terminée.
        Elle est similaire à la classe Single, mais ne produit pas d'élément de valeur.
        Elle est également similaire à la classe Maybe, mais ne peut pas produire d'éléments.
         */
        Completable completable = createCompletable();

        completable.subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onComplete() {
                System.out.println("Operation is complete");
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }
        });


    }

    private static Completable createCompletable() {
        return Completable.fromAction((Action) deleteItemFromDBAction());

    }

    private static Action deleteItemFromDBAction() {
        /*
        requete sur un service, calculation, database
         */
        return new Action() {
            @Override
            public void run() throws Throwable {
                /*
                appelé quand on subscribe to completable
                 */
                System.out.println("Delete from DB");
            }
        };
    }
}