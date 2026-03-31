package 백준.DP.Silver.BOJ_9461_파도반수열;

import java.io.*;
import java.util.*;

public class 파도반수열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 0; testCase < T; testCase++) {
            int N = Integer.parseInt(br.readLine());

            long[] dp = new long[101];

            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;
            dp[4] = 2;


            for(int i = 5; i <= N; i++) {
                dp[i] = dp[i - 1] + dp[i - 5];
            }

            sb.append(dp[N]).append("\n");
        }

        System.out.println(sb);
    }
}
