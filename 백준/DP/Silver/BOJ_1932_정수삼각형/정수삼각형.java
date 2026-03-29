package 백준.DP.Silver.BOJ_1932_정수삼각형;

import java.io.*;
import java.util.*;

public class 정수삼각형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N][N];

        StringTokenizer st;

        for(int i = 0; i < N; i++) {
            st= new StringTokenizer(br.readLine());

            for(int j = 0; j <= i; j++) {
                dp[i][j] += Integer.parseInt(st.nextToken());

                if(i + 1 < N) {
                    dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j]);
                }
            }
        }

        int max = 0;
        for(int i = 0; i < N; i++) {
            max = Math.max(max, dp[N - 1][i]);
        }

        System.out.println(max);

    }
}
