package com.bilgeadam.exercises;

import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class GasStopCounter {

    public int countGasStops(int destination, List<int[]> gasStops) {
        PriorityQueue<int[]> candidateStops = new PriorityQueue<>((l , r) -> -1 * Integer.compare(l[1] , r[1]));

        int currentGas = 10;
        int counter = 0;

        while (currentGas < destination) {

            Iterator<int[]> it = gasStops.iterator();

            while (it.hasNext()){
                int [] gasStop = it.next();
                if (gasStop[0] <= currentGas){
                    candidateStops.add(gasStop);
                    it.remove();
                }
            }

            /*for (int[] stop : gasStops) {
                if (stop[0] <= currentGas)
                    candidateStops.add(stop);
            }*/

            if (!candidateStops.isEmpty()) {
                currentGas += candidateStops.poll()[1];
                counter++;
            }
            else
                return -1;
        }
        return counter;
    }
}
