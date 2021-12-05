package com.bilgeadam.collections;

import java.util.*;

public class MapExamples {

    private HashMap<String, List<Integer>> personWorkDays = new HashMap<>();
    private LinkedHashMap<String, List<Integer>> personWorkDaysOrdered = new LinkedHashMap<>();
    private TreeMap<String, List<Integer>> personWordDaysSorted = new TreeMap<>();

    public void addRecord(String name, int workDayCount){
        addHashWorkDays(name, workDayCount);
        addLinkedWorkDays(name, workDayCount);
        addTreeWorkDays(name, workDayCount);
    }


    private void addHashWorkDays(String name, int workDayCount){
        if (!personWorkDays.containsKey(name)){
            List<Integer> values = new ArrayList<>();
            personWorkDays.put(name, values);
        }

        personWorkDays.get(name).add(workDayCount);
    }
    private void addLinkedWorkDays(String name, int workDayCount){
        if (!personWorkDaysOrdered.containsKey(name)){
            List<Integer> values = new ArrayList<>();
            personWorkDaysOrdered.put(name, values);
        }

        personWorkDaysOrdered.get(name).add(workDayCount);
    }
    private void addTreeWorkDays(String name, int workDayCount){
        if (!personWordDaysSorted.containsKey(name)){
            List<Integer> values = new ArrayList<>();
            personWordDaysSorted.put(name, values);
        }

        personWordDaysSorted.get(name).add(workDayCount);
    }


    //Sadece 'Key'leri SET olarak döndürme metodu

    public Set<String> getKeys(){
        return personWorkDays.keySet();
    }
    public Set<String> getOrderedKeys(){
        return personWorkDaysOrdered.keySet();
    }
    public Set<String> getSortedKeys(){
        return personWordDaysSorted.keySet();
    }
}
