package 백준.DP.Silver.BOJ_1463_1로만들기;

import java.io.*;
import java.util.*;

public class 일로만들기 {
    static int N;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 10 9 8 7 6 5 4 3 2 1
        // 0  1


        N = Integer.parseInt(br.readLine());

        dp= new int[N + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[N] = 0;

        for(int i = N; i > 0; i--) {

            int cnt = dp[i] + 1;

            if(i % 3 == 0) {
                dp[i / 3] = Math.min(dp[i / 3], cnt);
            }

            if(i % 2 == 0) {
                dp[i / 2] = Math.min(dp[i / 2], cnt);
            }

            dp[i - 1] = Math.min(dp[i - 1], cnt);


        }

        System.out.println(dp[1]);

    }
}
