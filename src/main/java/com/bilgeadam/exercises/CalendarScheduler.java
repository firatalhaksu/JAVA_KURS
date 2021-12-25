package com.bilgeadam.exercises;

import java.util.*;

public class CalendarScheduler {
    private final HashMap<String ,TreeMap<Integer, Integer>> reservedRooms;

    public CalendarScheduler() {
        this.reservedRooms = new HashMap<>();
    }

    public boolean reserveSpots(int start, int end, String room) {
        TreeMap<Integer,Integer> reservedSpots;

        if (!reservedRooms.containsKey(room)){
            reservedRooms.put(room, new TreeMap<>());
        }

        reservedSpots = reservedRooms.get(room);

        Map.Entry<Integer, Integer> lower = reservedSpots.lowerEntry(start);
        if (lower != null && lower.getValue() >= start) {
            start = lower.getKey();
            end = Math.max(end, lower.getValue());
            reservedSpots.replace(start, end);
        } else {
            reservedSpots.put(start, end);
        }

        Map.Entry<Integer, Integer> higher = reservedSpots.higherEntry(start);
        while (higher != null && higher.getKey() <= end) {
            reservedSpots.replace(start, Math.max(higher.getValue(), end));
            reservedSpots.remove(higher.getKey());
            higher = reservedSpots.higherEntry(higher.getKey());
        }
        return true;
    }

    public List<int[]> availableSpots(String room) {
        TreeMap<Integer,Integer> reservedSpots;
        List<int[]> response;

        if (!reservedRooms.containsKey(room))
            return null;

        reservedSpots = reservedRooms.get(room);
        response = new ArrayList<>();


        Map.Entry<Integer, Integer> previousEntry = reservedSpots.firstEntry();
        if (previousEntry != null && previousEntry.getKey() != 0) {
            response.add(new int[]{0, previousEntry.getKey()});
        }

        for (Map.Entry<Integer, Integer> entry : reservedSpots.entrySet()) {
            if (!entry.equals(reservedSpots.firstEntry())) {
                response.add(new int[]{previousEntry.getValue(), entry.getKey()});
                previousEntry = entry;
            }
        }

        if (previousEntry != null && previousEntry.getValue() < 24) {
            response.add(new int[]{previousEntry.getValue(), 24});
        }
        return response.isEmpty() ? List.of(new int[]{0, 24}) : response;
    }
}