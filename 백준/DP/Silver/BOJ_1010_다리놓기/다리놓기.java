package 백준.DP.Silver.BOJ_1010_다리놓기;

import java.io.*;
import java.util.*;

// 🔁
public class 다리놓기 {
    static int[][] dp = new int[31][31];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            sb.append(combination(M, N)).append("\n");
        }

        System.out.println(sb);
    }

    static int combination(int n, int r) {
        // dp 값이 존재할 경우, 그 값을 그대로 쓴다.
        if(dp[n][r] > 0) return dp[n][r];

        // ex) 5C5 또는 4C0 일 경우, 그 값은 1이 된다. (조합 공식)
        if(n == r || r == 0) {
            dp[n][r] = 1;
            return dp[n][r];
        }

        // 조합의 경우 nCr = (n-1)C(r-1) + (n - 1)C(r) -> 파스칼의 법칙
// 의미: n개 중 r개를 뽑는 경우의 수는,
// "특정한 한 명을 이미 뽑았다고 치고 남은 n−1명 중 r−1명을 더 뽑는 경우"와
// "그 한 명을 절대 안 뽑기로 하고 남은 n−1명 중 r명을 다 뽑는 경우"의 합과 같다.
        return dp[n][r] = combination(n - 1, r - 1) + combination(n - 1,  r);
    }
}
