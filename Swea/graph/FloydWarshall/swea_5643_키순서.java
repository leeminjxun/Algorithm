package Swea.graph.FloydWarshall;

import java.io.*;
import java.util.*;

public class swea_5643_키순서 {
    static int N, M;
    static boolean[][] reach;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            // 학생 수
            N = Integer.parseInt(br.readLine());
            // 키 비교 수
            M = Integer.parseInt(br.readLine());

            reach = new boolean[N + 1][N + 1];

            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());

                reach[a][b] = true;
            }

            for(int k = 1; k <= N; k++)
                for(int i = 1; i <= N; i++)
                    for(int j = 1; j <= N; j++) {
                        if(reach[i][k] && reach[k][j]) reach[i][j] = true;
                    }

            int ans = 0;
            for(int i = 1; i <= N; i++) {
                int cnt = 0;
                for(int j = 1; j <= N; j++) {
                    if(i == j) continue;
                    if(reach[i][j] || reach[j][i]) cnt++;
                }

                if(cnt == N - 1) ans++;
            }

            sb.append("#").append(testCase).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
