package 백준.DP.Gold.BOJ_2096_내려가기;

import java.io.*;
import java.util.*;

public class 내려가기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][3];

        for(int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][3];

        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        for(int i = 0; i < N - 1; i++) {
            for(int j = 0; j < 3; j++) {
                if(j - 1 >= 0) {
                    dp[i + 1][j - 1] = Math.max(dp[i + 1][j - 1], arr[i + 1][j - 1] + dp[i][j]);
                }

                dp[i + 1][j] = Math.max(dp[i + 1][j], arr[i + 1][j] + dp[i][j]);

                if(j + 1 < 3) {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], arr[i + 1][j + 1] + dp[i][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append((Math.max(dp[N - 1][0], Math.max(dp[N - 1][1], dp[N - 1][2]))));

        for(int i = 0; i < N - 1; i++) {
            for(int j = 0; j < 3; j++) {
                if(j - 1 >= 0) {
                    dp[i + 1][j - 1] = Math.min(dp[i + 1][j - 1], arr[i + 1][j - 1] + dp[i][j]);
                }

                dp[i + 1][j] = Math.min(dp[i + 1][j], arr[i + 1][j] + dp[i][j]);

                if(j + 1 < 3) {
                    dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], arr[i + 1][j + 1] + dp[i][j]);
                }
            }
        }

        sb.append(" ");
        sb.append((Math.min(dp[N - 1][0], Math.min(dp[N - 1][1], dp[N - 1][2]))));

        System.out.println(sb);

    }
}
