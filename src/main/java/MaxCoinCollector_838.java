// Daily Coding Problem 838 - Asked by Zillow
// You are given a 2-d matrix where each cell represents number of coins in that cell.
//Assuming we start at matrix[0][0], and can only move right or down,
//find the maximum number of coins you can collect by the bottom right corner.

public class MaxCoinCollector_838 {

    static int findMaxCoins(int coinMatrix[][]) {

        if (coinMatrix == null) return 0;

        int rows = coinMatrix.length;
        int columns = coinMatrix[0].length;

        int[][] tempMatrix = new int[rows] [columns];

        //Base
        tempMatrix[0] [0] = coinMatrix[0] [0];

        for (int c = 1; c < columns; c++)
            tempMatrix[0] [c] = tempMatrix[0] [c - 1] + coinMatrix[0] [c];

        for (int r = 1; r < rows; r++)
            tempMatrix[r] [0] = tempMatrix[r - 1] [0] + coinMatrix[r] [0];

        for (int r = 1; r < rows; r++)
            for (int c = 1; c < columns; c++)
                tempMatrix[r] [c] = Math.max(tempMatrix[r - 1] [c], tempMatrix[r] [c - 1]) + coinMatrix[r] [c];

        return tempMatrix[rows - 1] [columns - 1];
    }

    //Drive Program
    public static void main(String[] args) {

        int [][] coinMatrix = {{0,3, 1, 1}, {2,0, 0, 4}, {1,5,3,1}};
        System.out.println("Max coin : " + findMaxCoins(coinMatrix));
    }
}
