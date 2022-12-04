package com.cbsingh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TestClass {
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i = 0; t_i < T; t_i++)
        {
            String line = br.readLine().trim();
            String s1 = line.split(" ")[0];
            String s2 = line.split(" ")[1];
            int P = Integer.parseInt(s1);
            int Q = Integer.parseInt(s2);

            long out_ = solve(P, Q);
            System.out.println(out_);
        }
        wr.close();
        br.close();
    }
    static long solve(int P, int Q){
        // Write your code here
        long result = 0;

        for (int i = P; i <= Q; i++) {
            result += getStrength(i);
        }
        return result;
    }

    static int getStrength(int num) {
        if(num == 1) return 0;

        int smallestDivisor = 1;
        for(int i=2; i<num; i++) {
            if( !(num%i == 0)) {
                smallestDivisor =i;
                break;
            }
        }
        return 1 + getStrength(smallestDivisor);
    }
}
