package Swea.DP.D3.Swea_3282_Knapsack;

import java.io.*;
import java.util.*;

public class Knapsack {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {

            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] dp = new int[K + 1];

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                // 부피
                int V = Integer.parseInt(st.nextToken());
                // 가치
                int C = Integer.parseInt(st.nextToken());

                for(int j = K; j >= V; j--) {
                    dp[j] = Math.max(dp[j], dp[j - V] + C);
                }
            }

            Arrays.sort(dp);

            sb.append("#").append(testCase).append(" ").append(dp[K]).append("\n");
        }

        System.out.print(sb);
    }
}
