package 백준.DP.Silver.BOJ_2579_계단오르기;

import java.io.*;
import java.util.*;

public class 계단오르기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] stairs = new int[N + 1];
        int[][] dp = new int[N + 1][3];

        for(int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        /*
        // i 번째 계단을 처음 밟는 경우 (이 전에 두 계단 씩 오른 경우) -> dp[i][1]
        // i 번째 계단을 두 번째로 밟는 경우 (이 전 계단에서 한 계단 씩 오른 경우) -> dp[i][2]
        */

        // 첫 번째 계단에서는 처음 밟는 경우의 수 밖에 존재하지 않는다.
        dp[1][1] = stairs[1];

        for(int i = 2; i <= N; i++) {
            // 한 계단씩 오른 경우, 두개의 계단을 연속으로 밟았기에, 이전 계단에서 두 계단 씩 오른 경우를 더해줘야한다.
            dp[i][1] = Math.max(dp[i - 2][1], dp[i - 2][2]) + stairs[i];

            // 두 계단씩 오른 경우, 이전 계단에서 한 계단 씩 오른 경우와 두 계단 씩 오른 경우 중 최댓값을 구하여 더해줘야한다.
            dp[i][2] = dp[i - 1][1] + stairs[i];
        }

        System.out.println(Math.max(dp[N][0], dp[N][1]));
    }
}
