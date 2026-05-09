package Swea;

import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] dp = new int[K + 1];

            dp[0] = 1;

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                int n = Integer.parseInt(st.nextToken());

                for(int j = K; j >= n; j--) {
                    if(dp[j - n] != 0) {
                        dp[j] += dp[j - n];
                    }
                }
            }

            sb.append(dp[K]).append("\n");

        }

        System.out.print(sb);
    }
}
