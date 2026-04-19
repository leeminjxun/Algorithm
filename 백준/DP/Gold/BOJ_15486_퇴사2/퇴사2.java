package 백준.DP.Gold.BOJ_15486_퇴사2;

import java.io.*;
import java.util.*;

public class 퇴사2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 2];
        int[] T = new int[N + 1];
        int[] P = new int[N + 1];

        int maxPrice = 0;

        StringTokenizer st;
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N + 1; i++) {
            // 1. 오늘의 최대 수익을 저장
            maxPrice = Math.max(maxPrice, dp[i]);

            // N + 1 일이 됐을 경우 종료 -> N 일에 상담을 받는데 1일이 걸리는 경우
            if(i == N + 1) break;

            // i 번째 일에 상담이 끝나는 기간 계산
            int endTime = i + T[i];

            // endTime 이 N 일에 끝나는 경우만
            if(endTime <= N + 1) {

                // dp에 저장된 값과 현재까지의 maxPrice + dp[i] 를 비교
                dp[endTime] = Math.max(dp[endTime], maxPrice + P[i]);
            }
        }

        System.out.println(maxPrice);
    }
}
