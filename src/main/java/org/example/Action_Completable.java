package org.example;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.functions.Action;

import java.util.Scanner;

public class Action_Completable {
    public static void main(String[] args) {

        Action action = () -> System.out.println("Hello Renaud");

        /*
        Un Completable est similaire à un Observable à valeur unique,
        à l'exception qu'il n'émet aucun élément et ne signale que la fin ou l'erreur de l'opération.
        Les Completables sont utiles lorsque vous voulez effectuer une opération qui n'a pas de résultat, ou lorsque vous voulez représenter une fonction sans valeur de retour sous forme de flux réactif.
        Ils peuvent être utilisés pour représenter des opérations telles que l'enregistrement de données dans une base de données, l'envoi d'une demande à un serveur ou l'exécution d'un effet secondaire.
         */


        Completable completable = Completable.fromAction(action);


        completable.subscribe(() -> {
            System.out.println("Action ends");
        });

        new Scanner(System.in).nextLine();
    }
}