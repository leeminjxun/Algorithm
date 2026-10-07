package Swea.BackTracking.D5;

import java.io.*;
import java.util.*;

public class swea_1247_최적경로 {
    static int N, minDist;
    static int[] officePos, housePos;
    static int[][] clientPos;

    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(br.readLine());

            officePos = new int[2]; housePos = new int[2];
            clientPos = new int[N][2];

            st = new StringTokenizer(br.readLine());
            officePos[0] = Integer.parseInt(st.nextToken());
            officePos[1] = Integer.parseInt(st.nextToken());

            housePos[0] = Integer.parseInt(st.nextToken());
            housePos[1] = Integer.parseInt(st.nextToken());

            for(int i = 0; i < N; i++) {
                clientPos[i][0] = Integer.parseInt(st.nextToken());
                clientPos[i][1] = Integer.parseInt(st.nextToken());
            }

            minDist = Integer.MAX_VALUE;

            visited = new boolean[N];

            DFS(0, officePos[0], officePos[1], 0);

            sb.append("#").append(testCase).append(" ").append(minDist).append("\n");
        }

        System.out.print(sb);
    }

    static void DFS(int depth, int x, int y, int dist) {
        if(dist >= minDist) return;

        if(depth == N) {
            dist += calcDist(x, y, housePos[0], housePos[1]);

            minDist = Math.min(minDist, dist);
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                DFS(depth + 1, clientPos[i][0], clientPos[i][1],
                        dist + calcDist(x, y, clientPos[i][0], clientPos[i][1]));
                visited[i] = false;
            }
        }
    }

    static int calcDist(int x1, int y1, int x2, int y2) {
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }
}
