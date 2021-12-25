package com.bilgeadam.strings;

public class StringManipulation {

    public void createStrings() {
        String a = "ASD";
        String b = "ASD";
        //a ve b için ayrı 2 obje yaratılmıyor. aynı "ASD" referansına işaret ediyorlar String Pool'da.

        a = "ASD1";
        //a için String Pool'da yeni bir "ASD1" stringi yaratılır.

        b = new String("ASD");
        // new ile (zorla) yeni bir string objesi yaratıyoruz bu şekilde.
    }

    public String buildStringFromNames(String... names) {
        StringBuilder res = new StringBuilder();
        //StringBuilder yeni obje yaratıp-kullanıp-siler. Böylelikle String Pool şişirilmemiş olur.
        //metotlar ile de string manipüle edilerek sistem yorulmadan kullanılmış olur.

        for (String name : names) {
            res.append(name).append(", ");
        }
        res.delete(res.lastIndexOf(", "), res.length());

        //En sonunda .toString() ile çıktı alıp kullanıyoruz. String Pool şişmemiş oluyor.
        return res.toString();
    }

    public void printTurns(int... t){
        for (int turn:t) {
            System.out.printf(String.format("Turn-%d\n", turn));    //  %d --> DECIMAL
            System.out.printf(String.format("Turn-%x\n", turn));    //  %x --> HEXADECIMAL
            System.out.printf(String.format("Turn-%o\n", turn));    //  %o --> OCTAL

            //printf    --> "format"lı yazdırmak için kullanıyoruz.
            //%d %x %o  --> girdiğimiz string'in yanına (sayı) ekliyor. sayıyı da ',' ile yazıyoruz.
            //%f        --> float
            //%s        --> String
            //%1$ %2$...--> 1. değişken 2. değişken... (index belirtme)
        }
    }

    public void printNumbers(int x, float y){

        System.out.printf("X is %d", x);
        System.out.printf("Y is (Regular) %1$7.3f / (Scientific) %1$7.3e / (Hex) %1$7.3a / (Other) %1$7.3g ", y);

            //'.3'      --> float değerde .'dan sonra 3 basamak gösterir (aşağı/yukarı yuvarlama)
            //'7.'     --> .'dan önceki tam sayıdan önce 7 tane "boşluk" bırakıyor.
            //Yuvarlama işleminde gerçek değer değişmez, tutulur. Yalnızca gösterim için format kullanılır.

    }
}
