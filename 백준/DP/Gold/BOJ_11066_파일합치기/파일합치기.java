package 백준.DP.Gold.BOJ_11066_파일합치기;

import java.io.*;
import java.util.*;

public class 파일합치기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 0; testCase < T; testCase++) {
            int N = Integer.parseInt(br.readLine());

            int[] sum = new int[N + 1];

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++) {
                sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[N + 1][N + 1];

            for(int len = 2; len <= N; len++) {
                for(int start = 1; start + len - 1 <= N; start++) {
                    int end = start + len - 1;

                    dp[start][end] = Integer.MAX_VALUE;

                    for(int divide = start; divide < end; divide++) {
                        dp[start][end] = Math.min(dp[start][end],
                                dp[start][divide] + dp[divide + 1][end] + (sum[end] - sum[start - 1]));
                    }
                }
            }

            sb.append(dp[1][N]).append("\n");

        }

        System.out.println(sb);
    }
}
