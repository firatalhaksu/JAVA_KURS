package com.bilgeadam.generics;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Counter<MUHAMMET , T extends Number, E , S> {

    //<MUHAMMET> tipinde objeler oluşturmak için. (istenilen isim verilebilir)
    //Birden çok tip tanımlaması yapılabilir.
    //Her tip ayrı ayrı extend ettirilebilir.

    /*
    * "extends Number" generic'e Number sınırlaması koymayı sağlar.
    * sınırlama isteğe bağlıdır. zorunlu değil.
    * interface'ler ile de sınırlama yapılabilr. ancak yine "extend" ile çağırmamız gerek. "implement" ile değil.

    * extends-super kullanılıyor.
    * extends - generic'in alabileceği üst limit (tür)
    * super   - generic'in alabileceği alt limit (tür)
    *
    * dönen objeyi bir listede  SAKLAYACAKSAK "super" kullanılır.
    * dönen objeyi bir yerde    KULLANACAKSAK "extend" kullanılır.
    *


    private final List<T> list = new ArrayList<>();

    private int counter;

    public void addObject(T entity){
        counter++;
        list.add(entity);
    }

    public int totalElements() {
        return counter;
    }
    */

    private int counter = 0;
    private final Set<MUHAMMET> list;

    public Counter(){
        list = new HashSet<>();
    }

    public MUHAMMET addToList (MUHAMMET input){
        counter++;
        return list.add(input) ? input : null;
    }

    public int getElementCounter(){
        return counter;
    }

    public MUHAMMET getElement (int index){
        Iterator<MUHAMMET> it = list.iterator();
        int currentIndex = 0;
        while (it.hasNext()){
            MUHAMMET element = it.next();
            if (currentIndex++ == index){
                return element;
            }
        }

        return null;
    }

}
