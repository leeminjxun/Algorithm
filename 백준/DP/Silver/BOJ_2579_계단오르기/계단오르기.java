package 백준.DP.Silver.BOJ_2579_계단오르기;

import java.io.*;
import java.util.*;

public class 계단오르기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][2];

        for(int i = 1; i <= N; i++) {
            int value = Integer.parseInt(br.readLine());

            // 연속 1개 밟고 왔을 경우 (두 계단 씩 오른 경우)
            dp[i][0] = value;

            // 연속 2개 밝고 왔을 경우 (한 계단 씩 오른 경우)
            dp[i][1] = value;
        }

        for(int i = 2; i <= N; i++) {
            // 한 계단씩 오른 경우, 두개의 계단을 연속으로 밟았기에, 이전 계단에서 두 계단 씩 오른 경우를 더해줘야한다.
            dp[i][1] += dp[i - 1][0];

            // 두 계단씩 오른 경우, 이전 계단에서 한 계단 씩 오른 경우와 두 계단 씩 오른 경우 중 최댓값을 구하여 더해줘야한다.
            dp[i][0] += Math.max(dp[i - 2][1], dp[i - 2][0]);
        }

        int max = Math.max(dp[N][0], dp[N][1]);

        System.out.println(max);
    }
}
