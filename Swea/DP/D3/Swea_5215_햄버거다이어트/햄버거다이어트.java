package Swea.DP.D3.Swea_5215_햄버거다이어트;

import java.io.*;
import java.util.*;

public class 햄버거다이어트 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= tc; testCase++) {
            st = new StringTokenizer(br.readLine());
            // 재료 수
            int N = Integer.parseInt(st.nextToken());
            // 제한된 칼로리
            int L = Integer.parseInt(st.nextToken());

            // 맛 점수
            int[] T = new int[N + 1];

            // 칼로리 수
            int[] K = new int[N + 1];

            int[] dp = new int[L + 1];

            // 제한된 칼로리 L 보다 작거나 같으면서, 맛은 최댓값
            for(int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());

                // taste score
                T[i] = Integer.parseInt(st.nextToken());

                // kal score
                K[i] = Integer.parseInt(st.nextToken());

                // 내림차순으로 비교해야 중복 방지를 할 수 있다.
                for(int j = L; j >= K[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - K[i]] + T[i]);
                }
            }

            sb.append("#" + testCase + " " + dp[L]).append("\n");
        }

        System.out.println(sb);
    }
}

