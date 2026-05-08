package Swea.BackTracking.D4.Swea_1808_지희의고장난계산기;

import java.io.*;
import java.util.*;

public class 지희의고장난계산기_시간초과 {
    static final int max = Integer.MAX_VALUE;

    static boolean[] can;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {

            can = new boolean[10];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 10; i++) {
                can[i] = Integer.parseInt(st.nextToken()) == 1;
            }

            int X = Integer.parseInt(br.readLine());
            int[] dp = new int[X + 1];

            for(int i = 0; i <= X; i++) {
                dp[i] = makeNumber(i);
            }

            // 곱셈 분해
            for(int i = 2; i <= X; i++) {
                for(int j = 2; j * j <= i; j++) {
                    if(i % j == 0) {
                        int a = j;
                        int b = i / j;

                        if(dp[a] != max && dp[b] != max) {
                            dp[i] = Math.min(dp[i], dp[a] + dp[b] + 1);
                        }
                    }
                }
            }

            sb.append("#").append(testCase).append(" ");

            if(dp[X] == max) sb.append("-1");
            else sb.append(dp[X] + 1);

            sb.append("\n");
        }

        System.out.print(sb);
    }

    static int makeNumber(int i) {
        if(i == 0) {
            return can[i] ? 1 : max;
        }

        int cnt = 0;

        while(i > 0) {
            int digit = i % 10;

            if(!can[digit]) return max;

            cnt++;

            i /= 10;
        }

        return cnt;
    }
}
