package 백준.DP.Silver.BOJ_11726_2xN타일링;

import java.io.*;
import java.util.*;

public class _2xN타일링 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[2][N + 1];

        // 1칸 채워 넣은 경우
        dp[0][1] = 1;
        // 2칸 채워 넣은 경우
        if(N > 1) {
            dp[1][2] = 1;
        }

        for(int i = 2; i <= N; i++) {
            // 정수 오버플로우 방지
            dp[0][i] += ( dp[0][i - 1] + dp[1][i - 1] ) % 10007;

            dp[1][i] += ( dp[0][i - 2] + dp[1][i - 2] ) % 10007;
        }

        System.out.println(((dp[0][N] + dp[1][N])) % 10007);
    }
}
