package Swea.BackTracking.D4.Swea_1865_동철이의일분배;

import java.io.*;
import java.util.*;

public class 동철이의일분배 {
    static int N;
    static double res;
    static double[][] P;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());

            P = new double[N][N];
            visited = new boolean[N];

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    P[i][j] = Double.parseDouble(st.nextToken()) / 100.0;
                }
            }

            res = 0.0;

            dfs(0, 1.0);

            sb.append("#").append(tc).append(" ");
            sb.append(String.format("%.6f", res * 100)).append("\n");
        }
        System.out.print(sb);

    }

    static void dfs(int depth, double percent) {
        if(percent <= res) return;

        if(depth == N) {
            res = Math.max(res, percent);

            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, percent * P[depth][i]);
                visited[i] = false;
            }
        }
    }
}
