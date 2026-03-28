package 백준.DP.Silver.BOJ_1149_RGB거리;

import java.io.*;
import java.util.*;

public class RGB거리 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 1][3];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            dp[i][0] += Integer.parseInt(st.nextToken()); // R
            dp[i][1] += Integer.parseInt(st.nextToken()); // G
            dp[i][2] += Integer.parseInt(st.nextToken()); // B

            if(i == N) break;

            dp[i + 1][0] = Math.min(dp[i][1], dp[i][2]);
            dp[i + 1][1] = Math.min(dp[i][0], dp[i][2]);
            dp[i + 1][2] = Math.min(dp[i][0], dp[i][1]);

        }

        int RG = Math.min(dp[N][0], dp[N][1]);
        int GB = Math.min(dp[N][1], dp[N][2]);

        System.out.println(Math.min(RG, GB));
    }
}
