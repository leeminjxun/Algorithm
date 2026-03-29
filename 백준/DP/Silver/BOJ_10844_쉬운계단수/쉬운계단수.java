package 백준.DP.Silver.BOJ_10844_쉬운계단수;

import java.io.*;
import java.util.*;

public class 쉬운계단수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 1][10];

        Arrays.fill(dp[1], 1);
        dp[1][0] = 0;

        for(int i = 2; i <= N; i++) {
            for(int j = 0; j < 10; j++) {
                for(int k = 0; k < 10; k++) {
                    if(k - j == 1 || k - j == -1) dp[i][k] = (dp[i][k] + dp[i - 1][j]) % 1000000000;
                }
            }
        }

        long res = 0;
        for(int i = 0; i < 10; i++) {
            res += dp[N][i];
        }

        System.out.println(res % 1000000000);
    }
}
