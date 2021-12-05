package com.bilgeadam.stream;

import java.util.*;
import java.util.stream.Collectors;

public class Examples {
    List<Integer> scores = new ArrayList<>() {{
        add(5);
        add(47);
        add(18);
        add(63);
        add(72);
        add(98);
        add(90);
        add(85);
        add(51);
    }};

    public void printElements() {
        //iki satır da aynı işi yapıyor. scores'un değişkenlerini yazdırıyoruz.
        scores.forEach(System.out::println);
        scores.forEach(e -> System.out.printf("Element is %d\n", e));
    }

    public void printElements(int lowerLimit) {
        //lowerLimit'ten BÜYÜK olanları yazdırıyoruz.
        scores.stream().filter(f -> f > lowerLimit).forEach(e -> System.out.printf("Element is %d\n", e));
    }

    public void printElements(int lowerLimit, int higherLimit) {
        //lowerLimit'ten BÜYÜK & higherLimit'ten KÜÇÜK olanları yazdırıyoruz.
        scores.stream().filter(f -> f > lowerLimit && f < higherLimit).forEach(e -> System.out.printf("Element is %d\n", e));
    }

    public List<Grade> passingGrades() {
        //50'den büyük notların listesini döndürüyoruz.
        return scores.stream().filter(f -> f >= 50).map(Grade::new).collect(Collectors.toList());
    }

    Map<String, Integer> studentScores = new HashMap<>() {{
        put("Ali", 60);
        put("Veli", 45);
        put("Deli", 17);
        put("Küpeli", 93);
        put("Zırdeli", 80);
    }};

    public List<Students> passingStudents() {
        //notu 50'den büyük olanla öğrenci isim ve notlarını bilikte tutan listeyi azalan sıralı döndürüyoruz.
        return studentScores.entrySet()
                .stream().filter(e -> e.getValue() >= 50)
                .map(m -> new Students(m.getKey(), m.getValue()))
                .sorted(Comparator.comparingInt(Students::score).reversed())
                .collect(Collectors.toList());
    }

    public float successRate() {
        //dersten geçen öğrenci sayısının toplam sınıf sayısına oranı.
        return (float) studentScores.entrySet().stream().filter(e -> e.getValue() >= 50).count()
                / studentScores.entrySet().size();
    }
}

record Grade(int grade) {
}

record Students(String name, Integer score) {
}