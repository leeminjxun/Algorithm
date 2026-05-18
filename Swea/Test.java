package Swea;

import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[K + 1][N + 1];

        Arrays.fill(dp[1], 1);

        for(int k = 1; k < K; k++) {
            for(int n = 0; n <= N; n++) {
                for(int m = 0; m <= N; m++) {
                    if(n + m > N) continue;

                    dp[k + 1][n + m] += dp[k][n] % 1000000000;
                }
            }
        }

        System.out.print(dp[K][N] % 1000000000);
    }
}
