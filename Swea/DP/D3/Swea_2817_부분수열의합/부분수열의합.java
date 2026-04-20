package Swea.DP.D3.Swea_2817_부분수열의합;

import java.io.*;
import java.util.*;

public class 부분수열의합 {
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

            dp[0] = 1;

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                int a = Integer.parseInt(st.nextToken());

                for(int j = K; j >= a; j--) {
                    dp[j] += dp[j - a];
                }
            }

            sb.append("#" + testCase + " " + dp[K] + "\n");
        }

        System.out.println(sb);
    }
}
