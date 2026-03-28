package 백준.DP.Silver.BOJ_1912_연속합;

import java.io.*;
import java.util.*;

public class 연속합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];

        int max = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {

            int value = Integer.parseInt(st.nextToken());

            dp[i] = Math.max(value, dp[i - 1] + value);

            max = Math.max(max, dp[i]);
        }

        System.out.println(max);

    }
}
