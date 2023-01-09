package org.example.disposible;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

public class disposibleFct {

    public static void main(String[] args) throws InterruptedException {

        /*
        un Disposable est un objet qui permet de mettre fin à un abonnement entre un Observable et un Observer.
        Lorsqu'un Observer s'abonne à un Observable, il reçoit en retour un Disposable qu'il peut utiliser
        pour mettre fin à l'abonnement à tout moment. Cela peut être utile lorsque l'Observer n'a plus besoin
        de recevoir des éléments de l'Observable ou lorsque l'Observer est sur le point de se désinscrire de manière
        permanente. En appelant la méthode dispose() sur le Disposable,
        l'Observer peut mettre fin à l'abonnement et empêcher l'Observable de lui envoyer des éléments ultérieurs.


        Un Consumer est un objet qui permet de consommer ou de traiter une valeur produite par un Observable. Il est défini par la interface Consumer, qui ne comporte qu'une seule méthode abstraite : accept().
        Lorsqu'un Observable produit une valeur, la méthode accept() est appelée sur le Consumer et la valeur est passée en tant qu'argument.
        Le Consumer peut alors effectuer un traitement sur cette valeur de manière à en extraire des informations ou à effectuer une action.
        Un Observer, quant à lui, est un objet qui permet de recevoir et de réagir aux éléments produits par un Observable.
        Il est défini par la interface Observer, qui comporte trois méthodes abstraites : onNext(), onError() et onComplete(). Lorsqu'un Observable produit une valeur, la méthode onNext() est appelée sur l'Observer et la valeur est passée en tant qu'argument. Lorsque l'Observable termine sa production d'éléments de manière normale, la méthode onComplete() est appelée. Si l'Observable termine sa production d'éléments en raison d'une erreur, la méthode onError() est appelée à la place.
        En résumé, un Consumer est utilisé uniquement pour traiter une valeur produite par un Observable,
        tandis qu'un Observer est utilisé pour recevoir et réagir à tous les éléments produits par un Observable,
        y compris les erreurs et la fin de la production d'éléments.

        un consumer retourne un disponable
        pour un Observer il faut déclarer un compositeDisposible
         */
    }



}

