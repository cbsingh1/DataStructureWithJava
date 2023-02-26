package com.cbsingh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;

public class TreeMaxDepth {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i = 0; t_i < T; t_i++)
        {
            int N = Integer.parseInt(br.readLine().trim());
            int[][] edges = new int[N-1][2];
            for(int i_edges = 0; i_edges < N-1; i_edges++)
            {
                String[] arr_edges = br.readLine().split(" ");
                for(int j_edges = 0; j_edges < arr_edges.length; j_edges++)
                {
                    edges[i_edges][j_edges] = Integer.parseInt(arr_edges[j_edges]);
                }
            }
            String[] arr_w = br.readLine().split(" ");
            int[] w = new int[N];
            for(int i_w = 0; i_w < arr_w.length; i_w++)
            {
                w[i_w] = Integer.parseInt(arr_w[i_w]);
            }

            int[] out_ = max_depth(N, edges, w);
            System.out.print(out_[0]);
            for(int i_out_ = 1; i_out_ < out_.length; i_out_++)
            {
                System.out.print(" " + out_[i_out_]);
            }

            System.out.println();

        }

        wr.close();
        br.close();
    }
    static int[] max_depth(int N, int[][] edges, int[] w){
        // write your code here
        int[] result = {0, 0};
        HashSet<Integer> parentNodes;
        int currentNodeVal;
        boolean nextIteration = true;
        int depth=0;

        while (nextIteration) {
            nextIteration = false;
            parentNodes = new HashSet<>();
            for (int i = 0; i < edges.length; i++) {
                if(edges[i][0] != -1)
                    parentNodes.add(edges[i][0]);
            }
            depth = parentNodes.size();
            for (int i = 0; i < edges.length; i++) {
                currentNodeVal = edges[i][1];
                if (currentNodeVal != -1 &&
                        ! parentNodes.contains(currentNodeVal) &&
                        w[currentNodeVal-1] % 2 ==0 ) {
                    N = N-1;
                    edges[i][0]=-1;
                    edges[i][1]=-1;
                    nextIteration = true;
                }
            }
        }

        result[0] = N;
        result[1] = depth;
        return result;
    }
}
