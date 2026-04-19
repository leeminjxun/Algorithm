package 백준.DP.Gold.BOJ_2294_동전2;

import java.io.*;
import java.util.*;

public class 동전2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];

        for(int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[K + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for(int coin : coins) {
            for(int i = coin; i <= K; i++) {
                if(dp[i - coin] == Integer.MAX_VALUE) continue;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        System.out.println(dp[K] == Integer.MAX_VALUE ? -1 : dp[K]);

    }
}
