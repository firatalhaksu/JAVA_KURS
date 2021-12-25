package com.bilgeadam.collections;

import java.util.*;

public class ListExamples {

    private List<Integer> numberList;

    public ListExamples(boolean isArray) {
        this.numberList = isArray ? new ArrayList<>() : new LinkedList<>();
    }

    public int addElements(int... elements){
        for (int e : elements) {
            numberList.add(e);
        }

        return numberList.size();
    }

    public void removeElements(int elements){
            numberList.remove(Integer.valueOf(elements));
    }

    public boolean checkElements(int value){
        return numberList.contains(value);
    }

    public void clearList(){
        numberList.clear();
    }

    public void printIteratorElements(){
        Iterator <Integer> it = numberList.iterator();
        while (it.hasNext()){
            Integer elm = it.next();
            System.out.printf("Element is %d\n", elm);

            if (elm % 5 == 0)
                it.remove();
        }
    }

    public void printListIteratorElements(){
        ListIterator<Integer> it = numberList.listIterator();
        while (it.hasNext()){
            Integer elm = it.next();
            System.out.printf("Element is %d\n", elm);

            if (elm % 5 == 0)
                it.remove();

            if (it.nextIndex() % 3 == 0) {
                it.add(it.nextIndex() * 2 + 1);
                it.previous();

            }
        }
    }
}
