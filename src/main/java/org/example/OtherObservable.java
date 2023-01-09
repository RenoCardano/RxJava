package org.example;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.*;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;

import java.util.Scanner;

public class OtherObservable {
    /*
     La classe Single représente un flux de données qui ne contient qu'un seul élément.
     Elle peut être utilisée pour représenter une valeur unique qui sera produite par un Observable
     ou pour encapsuler une opération qui retourne une valeur unique.
     Elle est similaire à la classe Maybe,
     mais elle garantit qu'un seul élément sera produit par le flux de données.
     */
    public static void main(String[] args) {

        Single<String> single = createSingle();

        single.subscribe(new SingleObserver<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@NonNull String s) {
                System.out.println(s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println(e.getMessage());

            }
        });

        /*
        La classe Maybe dans RxJava est un type de flux de données qui peut ne produire aucun élément, un seul élément ou plusieurs éléments.
        Elle peut être utilisée pour représenter une valeur optionnelle qui sera produite par un Observable, ou pour encapsuler une opération qui peut ne pas retourner de valeur. Elle est similaire à la classe Single, mais elle n'est pas garantie pour produire un seul élément.
        Elle est également similaire à la classe Observable, mais elle ne peut pas produire plusieurs éléments.
         */

        Maybe<String> maybe = createMaybe();

        maybe.subscribe(new MaybeObserver<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@NonNull String s) {
                System.out.print(s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println(e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.print("tack completed");
            }
        });

    }

    private static Maybe<String> createMaybe() {
        return Maybe.create(emitter -> {
            String newContent = readFiles();
            if(newContent != null){
                emitter.onSuccess(newContent);
            } else {
                //dans ce contexte soit on retourne qlqchose soit rien
                //donc si rien alors on complète la tache
                emitter.onComplete();
            }
        });
    }

    private static String readFiles() {
        return null;
    }

    public static  Single<String> createSingle() {
        return Single.create(emitter -> {
            String users = fetchUsers();
            if(users != null){
                emitter.onSuccess(users);
            } else {
                emitter.onError(new Exception("Erreur pendant le chargement"));
            }
        });

    }

    public static String fetchUsers() {
        return "Renaud";
    }

}