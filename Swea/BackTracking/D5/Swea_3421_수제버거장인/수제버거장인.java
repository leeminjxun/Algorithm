package Swea.BackTracking.D5.Swea_3421_수제버거장인;

import java.io.*;
import java.util.*;

public class 수제버거장인 {
    static int N, M, ans;

    static boolean[][] badComb;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            badComb = new boolean[N + 1][N + 1];
            visited = new boolean[N + 1];

            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                badComb[a][b] = true;
                badComb[b][a] = true;
            }
            ans = 0;
            dfs(1);

            sb.append("#").append(testCase).append(" ").append(ans).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int depth) {
        if(depth == N + 1) {
            ans++;
            return;
        }

        dfs(depth + 1);

        if(isValid(depth)) {
            visited[depth] = true;
            dfs(depth + 1);
            visited[depth] = false;
        }
    }

    static boolean isValid(int idx) {
        for(int i = 1; i <= N; i++) {
            if(visited[i] && badComb[i][idx]) return false;
        }

        return true;
    }

}
