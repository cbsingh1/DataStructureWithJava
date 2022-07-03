package com.cbsingh.leetcode;

/*You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+').
You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.
In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot step outside the maze.
Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell that is at the border of the maze.
The entrance does not count as an exit. Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.

Example 1:
Input: maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], entrance = [1,2]
Output: 1
Explanation: There are 3 exits in this maze at [1,0], [0,2], and [2,3].
Initially, you are at the entrance cell [1,2].
- You can reach [1,0] by moving 2 steps left.
- You can reach [0,2] by moving 1 step up.
It is impossible to reach [2,3] from the entrance.
Thus, the nearest exit is [0,2], which is 1 step away.

Example 2:
Input: maze = [["+","+","+"],[".",".","."],["+","+","+"]], entrance = [1,0]
Output: 2
Explanation: There is 1 exit in this maze at [1,2].
[1,0] does not count as an exit since it is the entrance cell.
Initially, you are at the entrance cell [1,0].
- You can reach [1,2] by moving 2 steps right.
Thus, the nearest exit is [1,2], which is 2 steps away.

Example 3:
Input: maze = [[".","+"]], entrance = [0,0]
Output: -1
Explanation: There are no exits in this maze.
*/

import java.util.ArrayList;

public class LeetCode1926_NearestExitFromEntranceInMaze {
    int row, column;
    public  int nearestExit(char[][] maze, int[] entrance) {
        row = maze.length;
        column = maze[0].length;
        boolean [][]seen = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                seen[i][j]=false;
            }
        }
        int[][] dirs = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
        seen[entrance[0]][entrance[1]] = true;
        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[]{entrance[0], entrance[1], 0});

        while (list.size() > 0) {
            int[] arr = list.remove(0);
            if(arr[0] == 0 || arr[0]== row -1 || arr[1]==0 || arr[1]== column -1) {
                if(!(arr[0]==entrance[0] && arr[1]==entrance[1]))
                    return arr[2];
            }
            for(int[] dir : dirs) {
                int newX = arr[0] + dir[0];
                int newY = arr[1] + dir[1];
                if(isValid(newX, newY, maze, seen)) {
                    seen[newX][newY]=true;
                    list.add(new int[]{newX, newY, arr[2]+1});
                }
            }
        }
        return -1;
    }
    boolean isValid(int x, int y, char[][] maze, boolean[][]seen) {
        return (x>=0 && x< row && y>=0 && y< column && maze[x][y]=='.' && seen[x][y]==false);
    }

    public static void main(String[] args) {
        char[][] maze = {{'+','+','.','+'},{'.','.','.','+'},{'+','+','+','.'}};
        int []entrance = {1,2};

        System.out.println(new LeetCode1926_NearestExitFromEntranceInMaze().nearestExit(maze, entrance));
    }
}
