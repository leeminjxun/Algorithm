package Swea.DP.D3.Swea_3307_최장증가부분수열;

import java.io.*;
import java.util.*;

public class 최장증가부분수열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            int[] dp = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.fill(dp, 1);

            for(int i = 1; i < N; i++) {
                for(int j = 0; j < i; j++) {
                    if(arr[i] > arr[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }

            Arrays.sort(dp);

            sb.append("#").append(testCase).append(" ").append(dp[N - 1]).append("\n");
        }

        System.out.println(sb);
    }
}
