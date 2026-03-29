package 백준.DP.Gold.BOJ_11054_가장긴바이토닉부분수열;

import java.io.*;
import java.util.*;

public class 가장긴바이토닉부분수열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] seq = new int[N + 1];
        int[][] dp = new int[N + 1][2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        // {1 5 2 1 4 3 4 5 2 1} 의 가장 긴 바이토닉 부분 수열 -> {1, 2, 3, 4, 5, 2, 1}
        for(int i = 2; i <= N; i++) {
            for(int dec = i - 1; dec >= 1; dec--) {
                // {1, 5} 의 경우
                if(seq[i] > seq[dec]) {
                    dp[i][0] = Math.max(dp[i][0], dp[dec][0] + 1);
                }
            }
        }

        for(int i = N - 1; i >= 1; i--) {
            for(int inc = i + 1; inc <= N; inc++) {
                // {5, 2} 의 경우
                if(seq[i] > seq[inc]) {
                    dp[i][1] = Math.max(dp[i][1], dp[inc][1] + 1);
                }
            }
        }

        int max = -1;
        for(int i = 1; i <= N; i++) {
            max = Math.max(max, dp[i][0] + dp[i][1]);
        }

        System.out.println(max + 1);


    }
}