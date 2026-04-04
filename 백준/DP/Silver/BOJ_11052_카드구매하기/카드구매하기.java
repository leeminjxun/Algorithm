package 백준.DP.Silver.BOJ_11052_카드구매하기;

import java.io.*;
import java.util.*;

public class 카드구매하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N + 1];
        int[] dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + P[j]);
            }
        }

        System.out.println(dp[N]);
    }
}
