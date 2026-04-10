package 백준;
import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 0; testCase < T; testCase++) {
            int n = Integer.parseInt(br.readLine());

            int[][] dp = new int[3][n];

            for(int i = 1; i <= 2; i++) {
                st = new StringTokenizer(br.readLine());

                for(int j = 0; j < n; j++) {
                    dp[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 1; i < n; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[2][i - 1]);

                dp[1][i] += Math.max(dp[0][i - 1], dp[2][i - 1]);

                dp[2][i] += Math.max(dp[0][i - 1], dp[1][i - 1]);
            }

            sb.append(Math.max(dp[0][n - 1],Math.max(dp[1][n - 1], dp[2][n - 1]))).append("\n");
        }

        System.out.println(sb);
    }
}
