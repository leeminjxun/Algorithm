package 백준.DP.Silver.BOJ_9095_123더하기;

import java.io.*;
import java.util.*;

public class 일이삼더하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] dp = new int[12];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 4; i < 11; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        for(int testCase = 0; testCase < T; testCase++) {
            int n = Integer.parseInt(br.readLine());

            sb.append(dp[n]).append("\n");
        }

        System.out.println(sb);
    }
}
