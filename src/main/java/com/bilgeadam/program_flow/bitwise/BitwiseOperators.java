package com.bilgeadam.program_flow.bitwise;

public class BitwiseOperators {

    public void bitwiseOperations(int x, int y){
        System.out.println(x + " and " + y + " = " + (x & y));
        System.out.println(x + " or " + y + " = " + (x | y));
        System.out.println(x + " xor " + y + " = " + (x ^ y));
        System.out.println(x + " compliment = " + (~x));
        System.out.println(y + " compliment = " + (~y));

        System.out.println(x + " left shift by " + y + " = " + (x << y));
        System.out.println(x + " right shift by " + y + " = " + (x >> y));
        System.out.println(x + " zero fill right shift by " + y + " = " + (x >>> y));




    }
}
