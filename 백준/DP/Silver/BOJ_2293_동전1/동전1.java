package 백준.DP.Silver.BOJ_2293_동전1;

import java.io.*;
import java.util.*;

public class 동전1 {
    static int[] dp;
    static int[] arr;
    static int N, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        dp = new int[K + 1];

        dp[0] = 1;

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            for(int j = arr[i]; j <= K; j++) {
                dp[j] += dp[j - arr[i]];
            }
        }

        System.out.println(dp[K]);
    }

}
