package 백준.DP.Bronze.BOJ_2747_피보나치수;

import java.io.*;
import java.util.*;

public class 피보나치수 {
    static int N;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];


        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= N; i++) {
            dp[i] += (dp[i - 1] + dp[i - 2]);
        }

        System.out.println(dp[N]);


    }
}
