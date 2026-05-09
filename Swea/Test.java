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
            // taste 는 최댓값 But 칼로리는 정해진 만큼
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            // 최대 칼로리 값
            int L = Integer.parseInt(st.nextToken());

            int[] dp = new int[L + 1];

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                int taste = Integer.parseInt(st.nextToken());
                int K = Integer.parseInt(st.nextToken());

                for(int j = L; j >= K; j--) {
                    dp[j] = Math.max(dp[j], dp[j - K] + taste);
                }

            }

            Arrays.sort(dp);


            sb.append("#").append(testCase).append(" ");
            sb.append(dp[L]).append("\n");
        }

        System.out.print(sb);
    }
}
