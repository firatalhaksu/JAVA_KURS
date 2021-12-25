package com.bilgeadam.exercises;

import java.util.Arrays;

/**
 public static void main(String[] args) {

 int[][] maze = new int[3][3];

 maze[0][0] = 0;
 maze[0][1] = 0;
 maze[0][2] = 1;
 maze[1][0] = 1;
 maze[1][1] = 0;
 maze[1][2] = 0;
 maze[2][0] = 1;
 maze[2][1] = 1;
 maze[2][2] = 1;

 for (int i = 0; i < maze.length; i++) {
 for (int j = 0; j < maze[i].length; j++) {
 if (maze[i][j] == 0 )
 System.out.println("Labirentten X: " + i + " ve Y: " + j + " noktasında çıkıldı. ");
 else
 continue;
 }
 }
 }
 **/

public class MatrixTraveller {

    /**
     * Finds shortest disance from matrix[0][0] to matrix[m-1][n-1] where n = matrix.lenght m = matrix[0].lenght
     * @param matrix Matrix to Travel
     * @return minimum distance
     */

    public int mazeEscape (int[][] matrix){
        if (matrix.length == 0 || matrix[0].length ==0)
            return -1;

        int [][] visited = new int[matrix.length][matrix[0].length];
        for (int[] rows: visited){
            Arrays.fill(rows, Integer.MAX_VALUE);
        }
        int result = travel(matrix, 0, 0, visited, 0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int travel (int [][] matrix, int i, int j, int [][] visited, int counter){
        if (i == matrix.length -1 && j == matrix[i].length-1)
            return counter ;

        if (counter < visited[i][j]) {
            visited[i][j] = counter;

            if (matrix[i][j] == 1)
                return Integer.MAX_VALUE;
            else {
                int counterResult = Integer.MAX_VALUE;

                if (j < matrix[i].length - 1)
                    counterResult = Math.min(counterResult, travel(matrix, i, j + 1, visited, counter + 1)); //Right
                if (i < matrix.length - 1)
                    counterResult = Math.min(counterResult, travel(matrix, i, j + 1, visited, counter + 1)); //Up
                if (j > 0)
                    counterResult = Math.min(counterResult, travel(matrix, i, j + 1, visited, counter + 1)); //Left
                if (i > 0)
                    counterResult = Math.min(counterResult, travel(matrix, i, j + 1, visited, counter + 1)); //Down
                return counterResult;
            }
        }
        else {
            return Integer.MAX_VALUE;
        }
    }
}
