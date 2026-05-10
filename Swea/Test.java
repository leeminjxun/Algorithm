package Swea;

import java.io.*;
import java.util.*;

public class Test {
    static int N, B, min;

    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            arr = new int[N];
            visited = new boolean[N];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            min = Integer.MAX_VALUE;

            dfs(0, 0);

            sb.append("#").append(testCase).append(" ");
            sb.append(min == Integer.MAX_VALUE ? B : min - B).append("\n");

        }

        System.out.print(sb);
    }

    static void dfs(int depth, int sum) {
        if(sum > min) return;

        if(sum >= B) {
            min = Math.min(min, sum);

            return;
        }

        if(depth == N) {
            return;
        }

        dfs(depth + 1, sum + arr[depth]);
        dfs(depth + 1, sum);
    }
}
