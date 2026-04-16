package Swea.DP.D4.Swea_3752_가능한시험점수;

import java.io.*;
import java.util.*;

public class 가능한시험점수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());

            int sum = 0;
            int[] score = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                score[i] = Integer.parseInt(st.nextToken());
                sum += score[i];
            }

            boolean[] dp = new boolean[sum + 1];

            dp[0] = true;

            for(int i = 0; i < N; i++) {
                int s = score[i];

                for(int j = sum; j >= 0; j--) {
                    if(dp[j]) {
                        dp[j + s] = true;
                    }
                }
            }

            int cnt = 0;

            for(boolean p : dp) {
                if(p) cnt++;
            }

            sb.append("#" + testCase + " " + cnt).append("\n");
        }

        System.out.println(sb);
    }
}
