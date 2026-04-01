package 백준.DP.Silver.BOJ_9465_스티커;

import java.io.*;
import java.util.*;

public class 스티커 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 0; testCase < T; testCase++) {
            int N = Integer.parseInt(br.readLine());

            int[][] stickers = new int[2][N + 1];
            for(int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());

                for(int j = 1; j <= N; j++) {
                    stickers[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[3][N + 1];

            for(int i = 1; i <= N; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[2][i - 1]);
                dp[1][i] = Math.max(dp[2][i - 1], dp[0][i - 1]) + stickers[0][i];
                dp[2][i] = Math.max(dp[1][i - 1], dp[0][i - 1]) + stickers[1][i];
            }

            sb.append(Math.max(dp[0][N], Math.max(dp[1][N], dp[2][N]))).append("\n");

        }

        System.out.println(sb);
    }
}
