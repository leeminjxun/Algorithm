package Swea.BackTracking.D3.Swea_9229_한빈이와SpotMart;

import java.io.*;
import java.util.*;

public class 한빈이와SpotMart {
    static int N;

    static long M, max;

    static long[] arr;

    static boolean[] visited;

    static void dfs(int depth, long sum) {
        if(sum > M) return;

        if(depth == 2) {
            max = Math.max(max, sum);

            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, sum + arr[i]);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");

            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new long[N];
            visited = new boolean[N];

            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }

            max = 0;

            dfs(0, 0);

            sb.append(max == 0 ? -1 : max).append("\n");
        }

        System.out.println(sb);
    }
}
