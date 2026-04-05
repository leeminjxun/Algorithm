package 백준.DP.Silver.BOJ_1309_동물원;

import java.io.*;
import java.util.*;

public class 동물원 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[N + 1];

        Arrays.fill(dp, 1);
        dp[0] = 0;

        long acc = 0;
        for(int i = 1; i < N; i++) {
            dp[i + 1] += dp[i] + acc;
            acc += dp[i] * 2;

            dp[i + 1] %= 9901;
            acc %= 9901;
        }

        long cnt = 1;
        for(long c : dp) {
            cnt += c * 2;
        }

        System.out.println(cnt % 9901);
    }
}
