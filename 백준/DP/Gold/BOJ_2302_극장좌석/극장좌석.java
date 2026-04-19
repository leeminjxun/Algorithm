package 백준.DP.Gold.BOJ_2302_극장좌석;

import java.io.*;
import java.util.*;

public class 극장좌석 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[41];

        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int M = Integer.parseInt(br.readLine());

        int vip = 0;
        int prevVip = 0;

        int cnt = 1;
        for(int i = 0; i < M; i++) {
            vip = Integer.parseInt(br.readLine());

            cnt *= dp[vip - prevVip - 1];

            prevVip = vip;
        }

        cnt *= dp[N - prevVip];

        System.out.println(cnt);
    }
}
