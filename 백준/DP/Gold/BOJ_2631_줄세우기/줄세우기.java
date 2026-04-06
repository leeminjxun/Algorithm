package 백준.DP.Gold.BOJ_2631_줄세우기;

import java.io.*;
import java.util.*;

public class 줄세우기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N + 1];
        int[] dp = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            seq[i]= Integer.parseInt(br.readLine());
        }

        // seq[] = {3, 7, 5, 2, 6, 1, 4}

        Arrays.fill(dp, 1);

        for(int i = 2; i <= N; i++) {
            for(int j = 1; j < i; j++) {
                if(seq[i] > seq[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for(int n : dp) {
            max = Math.max(max, n);
        }

        System.out.println(N - max);

    }
}
