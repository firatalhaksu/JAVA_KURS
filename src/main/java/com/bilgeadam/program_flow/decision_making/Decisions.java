package com.bilgeadam.program_flow.decision_making;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Decisions {

    public void printRemainingDays(String input){

        //switch statement
        //case'ler içinde sabit değer yer alabilir. input ile case birebir aynı olmalıdır.
        //avantajı "break"leri istediğin gibi belirleyebilirsin.

        switch (input){
            case "Monday":
                System.out.println("Monday");
                break;
            case "Tuesday":
                System.out.println("Tuesday");
                break;
            case "Wednesday":
                System.out.println("Wednesday");
                break;
            case "Thursday":
                System.out.println("Thursday");
                break;
            case "Friday":
                System.out.println("Friday");
                break;
            case "Saturday":
                System.out.println("Saturday");
                break;
            case "Sunday":
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Unexpected input " + input);
                break;
        }
    }

    public void printDay(String input){

        //switch expression
        //case'ler tek satırda virgül ile yazılabilir.
        //komut "->" sonrasına yazılır.
        //break yazılmaz.
        //if'ten çok daha hızlı çalışır. ancak if kadar esnek değildir.

        System.out.println("Today is " +

            switch (input){
                case "Monday", "Thusday", "Wednesday", "Thursday", "Friday" -> "Weekday";
                case "Saturday", "Sunday" -> "Weekend";
                default -> "!! Unexpected input !!";
            }
        );
    }

    public void printEvenNumbers(Float x) {

        //referrence type kullanıyorsak, "null" ve "unexpected" durumlarını tanımlamak tavsiyedir.
        //if döngüsünde en son "else" case ile beklenmedik durumların döndürülmesi tavsiyedir.

        if (x == null){
            System.out.println("Given number is null!");
        }
        else if (x % 2 == 0){
            System.out.println(x + " is an Even Number.");
        }
        else if(x % 2 == 1) {
            System.out.println(x + " is an Odd Number.");
        }
        else {
            System.out.println("Unexpected case for " + x);
        }
    }

    public void printOddOrEvenNumbers(double x){
        /*if (Double.isNaN(x) || Double.isFinite(x)){
            System.out.println("Unexpected case for " + x);
        } else*/
        if (Double.isFinite(x)){

            //if koşul yazımında "? ve :" yazımıyla koşul True ise ilk durumu, değilse : sonrasını çıkartır.

            System.out.println(x + " is an " + ((x % 2 == 0) ? "Even" : "Odd") + " Number!");
        }
        else {
            System.out.println("Unexpected case for " + x);
        }
    }

    public void printNumbersFor(int [] ints){
        for (int i = 0, j = 6; i < ints.length && ints[i] < 143; i++ , j *= 2) {

            //bu şekilde yazım ile koşul False olduğu anda loop sona erer.
            //tüm elemanların kontrol edilmesi isteniyorsa; for içine if ile yazılmalı.
            //if(ints[i] < 143)

            //başlangıç (ilk) ve işlem (son) kısımları "," ile birden fazla yazılabilir.
            //kontrol (orta) kısmı da logical operatörler ile birden fazla durumla yazılabilir.

            System.out.println("ints["+i+"] = "+ints[i]);
        }
    }

    public void printNumbersWhile(int []ints){

        int i = 0;
        while (i < ints.length){
            System.out.println("ints[" + i + "] = "+ints[i++]);
        }
    }

    public void printStrings(String... strings){
        int i = 0;

        do {
            System.out.println(strings[i++]);
        } while (++i < strings.length);
    }

}
