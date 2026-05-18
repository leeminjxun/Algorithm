package programmers.DP.Lv3.N으로표현;

import java.util.*;

public class N으로표현 {
    public int solutino(int N, int number) {
        Set<Integer>[] dp = new HashSet[9];

        for(int i = 1; i <= 8; i++) {
            dp[i] = new HashSet<>();
        }

        for(int i = 1; i <= 8; i++) {
            int repeated = 0;

            for(int j = 0; j < i; j++) {
                repeated = repeated * 10 + N;
            }

            dp[i].add(repeated);

            for(int j = 1; j < i; j++) {
                for(int a : dp[j]) {
                    for(int b : dp[i - j]) {
                        dp[i].add(a + b);
                        dp[i].add(a - b);
                        dp[i].add(a * b);

                        if(b != 0) {
                            dp[i].add(a / b);
                        }
                    }
                }
            }

            if(dp[i].contains(number)) return i;
        }

        return -1;
    }
}
