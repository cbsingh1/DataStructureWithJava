package com.cbsingh;

import java.io.IOException;

public class MaxAlternatingSubArray {

    public static void main(String[] args) throws IOException {
/*        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i = 0; t_i < T; t_i++)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] arr_A = br.readLine().split(" ");
            int[] A = new int[N];
            for(int i_A = 0; i_A < arr_A.length; i_A++)
            {
                A[i_A] = Integer.parseInt(arr_A[i_A]);
            }

            long out_ = interestingSum(N, A);
            System.out.println(out_);

        }

        wr.close();
        br.close();*/

        int arr[] = {-4, -10, 3, 5};
        long result = interestingSum(arr.length, arr);
        System.out.println(result);
    }

    static long interestingSum(int N, int[] A){
        // Write your code here
        long sum = Integer.MIN_VALUE;
        long currentSum =0;

        for(int i=0; i<A.length; i++) {
            if(i%2==1)
                currentSum -= A[i];
            else
                currentSum = Math.max(currentSum + A[i], A[i]);

            sum = Math.max(sum, currentSum);
        }

        currentSum =0;
        for(int i=1; i<A.length; i++) {
            if(i%2==0)
                currentSum -= A[i];
            else
                currentSum = Math.max(currentSum + A[i], A[i]);

            sum = Math.max(sum, currentSum);
        }
        return sum;
    }
}


