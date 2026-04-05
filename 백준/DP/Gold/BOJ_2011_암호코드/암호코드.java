package 백준.DP.Gold.BOJ_2011_암호코드;

import java.io.*;
import java.util.*;

public class 암호코드 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String code = br.readLine();
        int N = code.length();

        int[] passCode = new int[N + 1];

        for(int i = 0; i < N; i++) {
            passCode[i + 1] = code.charAt(i) - '0';
        }

        if(passCode[1] == 0) {
            System.out.println(0);
            return;
        }

        long[] dp = new long[N + 1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= N; i++) {
            int one = passCode[i];
            int two = passCode[i - 1] * 10 + passCode[i];

            if(1 <= one && one <= 9) {
                dp[i] += dp[i - 1];
                dp[i] %= 1000000;
            }

            if(10 <= two && two <= 26) {
                dp[i] += dp[i - 2];
                dp[i] %= 1000000;
            }
        }

        System.out.println(dp[N] % 1000000);
    }
}
