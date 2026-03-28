package 백준.DP.Silver.BOJ_2156_포도주시식;

import java.io.*;
import java.util.*;

public class 포도주시식 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] wine = new int[N + 1];
        int[][] dp = new int[N + 1][3];

        // dp[N][0] -> 현재 와인잔을 마시지 않은 경우
        // dp[N][1] -> 현재 와인잔을 마신 경우
        // dp[N][2] -> 현재 와인잔과 다음 와인잔 까지 마신 경우

        for(int i = 1; i <= N; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        int maxDrink = 0;

        dp[1][0] = 0;
        dp[1][1] = wine[1];
        dp[1][2] = 0;

        for(int i = 2; i <= N; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
            dp[i][1] = dp[i - 1][0] + wine[i];
            dp[i][2] = dp[i - 1][1] + wine[i];
        }

        System.out.println(Math.max(dp[N][0], Math.max(dp[N][1], dp[N][2])));
    }
}
