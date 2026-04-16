package Swea.BackTracking.D4.Swea_1486_장훈이의높은선반;

import java.io.*;
import java.util.*;

public class 장훈이의높은선반 {
    static int N, B, minH;

    static int[] member;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            member = new int[N];

            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++) {
                member[i] = Integer.parseInt(st.nextToken());
            }

            minH = Integer.MAX_VALUE;

            dfs(0, 0);

            int res = minH - B;

            sb.append("#" + testCase + " " + res).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int idx, int sum) {
        if(sum >= minH) return;

        if(sum >= B) {
            minH = Math.min(minH, sum);
            return;
        }

        if(idx == N) return;

        dfs(idx + 1, sum + member[idx]);
        dfs(idx + 1, sum);
    }
}
