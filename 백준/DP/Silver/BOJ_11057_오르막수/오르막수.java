package 백준.DP.Silver.BOJ_11057_오르막수;

import java.io.*;
import java.util.*;

public class 오르막수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N + 1][10];

        Arrays.fill(dp[1], 1);

        for(int i = 2; i <= N; i++) {
            for(int j = 0; j <= 9; j++) {
                for(int k = j; k <= 9; k++) {
                    dp[i][j] += dp[i - 1][k] % 10007;
                }
            }
        }

        long count = 0;
        for(long cnt : dp[N]) {
            count += cnt % 10007;
        }
        System.out.println(count % 10007);
    }
}
