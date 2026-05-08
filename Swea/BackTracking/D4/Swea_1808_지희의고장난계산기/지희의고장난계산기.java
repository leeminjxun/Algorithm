package Swea.BackTracking.D4.Swea_1808_지희의고장난계산기;

import java.io.*;
import java.util.*;

public class 지희의고장난계산기 {
    static final int max = Integer.MAX_VALUE;

    static boolean[] can;
    static int[] memo;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());

            can = new boolean[10];

            for(int i = 0; i < 10; i++) {
                can[i] = Integer.parseInt(st.nextToken()) == 1;
            }

            int X = Integer.parseInt(br.readLine());

            memo = new int[X + 1];
            Arrays.fill(memo, -1);

            int res = dfs(X);

            sb.append("#").append(testCase).append(" ");

            if(res == max) sb.append("-1");
            else sb.append(res + 1);

            sb.append("\n");
        }

        System.out.print(sb);

    }

    static int dfs(int X) {

        if(X <= 0) return max;

        if(memo[X] != -1) return memo[X];

        int min = makeNumber(X);

        for(int i = 2; i * i <= X; i++) {
            if(X % i == 0) {
                int a = i;
                int b = X / i;

                int left = dfs(a);
                int right = dfs(b);

                if(left != max && right != max) {
                    min = Math.min(min, left + right + 1);
                }
            }
        }

        return memo[X] = min;
    }

    static int makeNumber(int num) {
        if(num == 0) {
            return can[num] ? 1 : max;
        }
        int cnt = 0;
        while(num > 0) {
            int digit = num % 10;

            if(!can[digit]) return max;

            cnt++;
            num /= 10;
        }

        return cnt;
    }
}
