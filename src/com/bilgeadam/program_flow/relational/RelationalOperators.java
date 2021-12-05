package com.bilgeadam.program_flow.relational;

public class RelationalOperators {

    public void computeRelations(float x, float y){
        System.out.println("Is " + x + " greater than " + y +" = " + (x > y));
        System.out.println("Is " + x + " lesser than " + y +" = " + (x < y));
        System.out.println("Is " + x + " greater than or equals to " + y +" = " + (x >= y));
        System.out.println("Is " + x + " lesser than or equals to " + y +" = " + (x <= y));
        System.out.println("Is " + x + " equals to " + y +" = " + (x == y));
        System.out.println("Is " + x + " not equals to " + y +" = " + (x != y));

        // == operatörü değişkenlerin RAM'de aynı adreste olup olmadıklarını kontrol eder.
        // != operarörü de aynı şekilde.

    }
}
