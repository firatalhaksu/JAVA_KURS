package com.bilgeadam.generics;

import java.util.ArrayList;
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();      //Yalnızca <String> tipinde parametre alabilir.
        strings.add("jhfeje");
        strings.add(null);
        strings.add("");
        //strings.add(4);                                   //String dışında parametre kabul etmez.


        //İki şekilde de kullanılabilir.
        System.out.println(Arrays.toString(strings.toArray()));
        System.out.println(strings);
    }
}
