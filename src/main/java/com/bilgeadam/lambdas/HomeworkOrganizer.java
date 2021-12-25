package com.bilgeadam.lambdas;

import java.util.*;

public class HomeworkOrganizer {
    private final Map<String, List<Map.Entry<String, Integer>>> studentHomeworks;
    private final Map<String, Homework> studentHomeworkDefinitions;

    public HomeworkOrganizer() throws InterruptedException {
        studentHomeworks = new HashMap<>();
        studentHomeworkDefinitions = new HashMap<>();
    }

    public void defineStudent(String name, Homework homework) {
        studentHomeworkDefinitions.put(name, homework);
        studentHomeworks.put(name, new ArrayList<>());
    }

    public boolean addHomework(String student, String lesson, int duration) {
        if (studentHomeworks.containsKey(student)) {
            studentHomeworks.get(student).add(new AbstractMap.SimpleImmutableEntry<>(lesson, duration));
            return true;
        } else
            return false;
    }

    void finisHomeworks() {
        for (Map.Entry<String, List<Map.Entry<String, Integer>>> student : studentHomeworks.entrySet()) {
            Homework executer = studentHomeworkDefinitions.get(student.getKey());
            for (Map.Entry<String, Integer> homework : student.getValue()) {
                executer.doHomework(homework.getKey(), homework.getValue());
            }
        }
    }
}