package Swea.DP.D3.Swea_3304_최장공통부분수열;

import java.io.*;
import java.util.*;

public class 최장공통부분수열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());

            String s1 = st.nextToken();
            String s2 = st.nextToken();

            int[][] dp = new int[s1.length() + 1][s2.length() + 1];

            for(int i = 1; i <= s1.length(); i++) {
                for(int j = 1; j <= s2.length(); j++) {
                    if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }

            sb.append("#").append(testCase).append(" ").append(dp[s1.length()][s2.length()]).append("\n");
        }

        System.out.println(sb);
    }
}
