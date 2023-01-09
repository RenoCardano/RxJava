package org.example.operator;


import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

public  class operators {
    public static void main(String[] args) {
        //filter permet de retirer un element répondant à la fonction
        Disposable observable = Observable.just("Hello", "my", "World")
                .filter(item -> item.length() != 2)
                .subscribe(item -> System.out.println(item));

    }
}
