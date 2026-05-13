package programmers.DP.Lv2.완전범죄;

import java.util.*;

public class 완전범죄 {
    static final int INF = Integer.MAX_VALUE;

    public int solution(int[][] info, int n, int m) {
        int answer = 0;

        int[] dp = new int[m];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for(int i = 0; i < info.length; i++) {
            int aTrace = info[i][0];
            int bTrace = info[i][1];

            int[] next = new int[m];
            Arrays.fill(next, INF);

            for(int b = 0; b < m; b++) {
                if(dp[b] == INF) continue;

                int nextA = dp[b] + aTrace;
                if(nextA < n) {
                    next[b] = Math.min(next[b], nextA);
                }

                int nextB = b + bTrace;
                if(nextB < m) {
                    next[nextB] = Math.min(next[nextB], dp[b]);
                }
            }

            dp = next;
        }

        Arrays.sort(dp);

        return dp[0] == INF ? -1 : dp[0];
    }
}
