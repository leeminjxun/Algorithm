package Swea.DP.D2.Swea_2005_파스칼의삼각형;

import java.io.*;
import java.util.*;

public class 파스칼의삼각형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());

            int[][] dp = new int[N][N];

            dp[0][0] = 1;

            sb.append("#" + testCase).append("\n");

            sb.append(dp[0][0]).append("\n");
            for(int i = 1; i < N; i++) {
                dp[i][0] = 1;
                sb.append(dp[i][0]).append(" ");
                for(int j = 1; j < i; j++) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];

                    sb.append(dp[i][j]).append(" ");
                }
                dp[i][i] = 1;
                sb.append(dp[i][i]);
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}
