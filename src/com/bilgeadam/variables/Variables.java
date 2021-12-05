package com.bilgeadam.variables;

public class Variables {
    //integer variable types
    //integer default değer "0"dır.

    byte myByte = 123;
    short myShort = 498;
    int myInt = 548;
    long myLong = 38_475_893_479_047_054L;

    //boolean variables types
    //bolean default değer "false"dir.

    boolean myFLAG = true;
    boolean myNewFLAG;

    //char variable type

    char myChar = 'X';

    //string variable type
    //non-primitive (referrence) type olduğundan BÜYÜK harf ile başlar.

    String myString = "This is my STRING!";

    //floating (kesirli) points variable type
    //float için sonuna "F" yazılır.
    //double değer çok uzun ise sonuna "F" veya ".0" yazılmalıdır.
    //float ile double arasındaki fark, sakladıkları değer uzunluğudur.

    float myFloat = 544.548F;
    double myDouble = 544.548;

    //sonuna F yazarak float tipinde işlem yapmak için zorlanmış olur.

    float myNewFloat = 10F / 3;
    double myNewDouble = 10F / 3;

    //referrence types
    //type değerleri büyük harf ile başlar. (String, Long, Boolean, Integer, Byte...)
    //değer atanmamış değişkenlerin default değeri "null" olarak döner.
    //"null pointer exception" hatası verir.
    //String de bir referrence type'dır.
    //Java referrence type kullanımında extra fonksiyonlar sunar.
    //"." ile fonksiyonlar görülebilir.
    //type'ların birbirine dönüşümlerinde kolaylık sağlar. (Integer to String, String to Integer gibi)


    public static void main(String[] args) {

        Variables vars = new Variables();

        System.out.println ("My byte is  : " + vars.myByte);
        System.out.println ("My short is : " + vars.myShort);
        System.out.println ("My int is   : " + vars.myInt);
        System.out.println ("My long is  : " + vars.myLong);


        //casting; narrowing

        short newShort = vars.myByte;
        System.out.println ("My new short is : " + newShort);

        int newInt = vars.myShort;
        System.out.println ("My new int is : " + newInt);

        long newLong = vars.myInt;
        System.out.println ("My new long is : " + newLong);

        newInt = (int) vars.myLong;

        System.out.println ("My second new int is : " + newInt);
        System.out.println("My FLAG is : " + vars.myFLAG);
        System.out.println("My New FLAG is : " + vars.myNewFLAG);
        System.out.println("My char is : " + vars.myChar);
        System.out.println("My String is :  " + vars.myString);
        System.out.println("My Float is : " + vars.myFloat);
        System.out.println("My Double is : " + vars.myDouble);
        System.out.println("My New Float is : " + vars.myNewFloat);
        System.out.println("My New Double is : " + vars.myNewDouble);

    }
}