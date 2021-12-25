package com.bilgeadam.generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NameAppender {

    private final List<? super Number> saveLogs = new ArrayList<>();

    public <T extends Number, S extends Serializable, E> String appendName (T input, String name){

        return String.format("%s: %s",input + name);
    }
}
