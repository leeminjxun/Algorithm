package Swea;

import java.io.*;
import java.util.*;

public class Test {
    static int N;

    static double max;

    static double[][] P;

    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder() ;
        for(int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(br.readLine());

            P = new double[N][N];
            visited = new boolean[N];

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    P[i][j] = Double.parseDouble(st.nextToken()) / 100.0;
                }
            }

            max = 0.0;

            dfs(0, 1.0);

            sb.append("#").append(testCase).append(" ");
            sb.append(String.format("%.6f", max * 100.0)).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int depth, double sum) {
        if(sum <= max) return;

        if(depth == N) {
            max = Math.max(max, sum);
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, sum * P[depth][i]);
                visited[i] = false;
            }
        }
    }

}
