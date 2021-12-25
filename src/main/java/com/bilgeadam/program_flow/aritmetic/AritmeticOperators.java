package com.bilgeadam.program_flow.aritmetic;

public class AritmeticOperators {

    public int sum(int x, int y) {
        return x + y;
    }

    public float subtraction(float x, float y) {
        return x - y;
    }

    //long'un bit değeri daha büyük olduğundan; inputları short almak, bit sınır değerleri içinde kalmayı sağlar.
    //public long multipication(short x, short y){
    //    return (short) (x * y);

    public int multipication(short x, short y) {
        return x * y;
    }

    public float division(int x, int y) {
        return (float) x / y;
    }

    //++ işleminde mothod içinde olduğumuz için değişkenin soluna yazılmalı
    //çünkü method her seferinde çağırılır ve başa döner
    //dolayısıyla sağa yazılırsa değişkenin değeri döndürülür ve sonra arttırır
    //bu da istenilen değeri geri döndürmemiş olur

    public byte incrementByOne(byte x) {
        return ++x;
    }

    public long decrementByOne(long x) {
        return --x;
    }

}
