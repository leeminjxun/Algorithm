package Swea.Dijkstra.D4;

import java.io.*;
import java.util.*;

public class Swea_1249_보급로 {
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};

    static int N;
    static int[] start, end;
    static int[][] grid, dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(br.readLine());

            grid = new int[N][N];
            dist = new int[N][N];

            start = new int[] {0, 0};
            end = new int[] {N - 1, N - 1};

            for(int i = 0; i < N; i++) {
                String s = br.readLine();

                for(int j = 0; j < N; j++) {
                    grid[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
                }
            }

            for(int i = 0; i < N; i++) {
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }
            dist[0][0] = 0;

            sb.append("#").append(testCase).append(" ").append(dijkstra()).append("\n");
        }

        System.out.print(sb);
    }

    static int dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[] {0, 0, 0});

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();

            int cr = cur[0], cc = cur[1], value = cur[2];

            if(cr == end[0] && cc == end[1]) return value;

            for(int dir = 0; dir < 4; dir++) {
                int nr = cr + dr[dir];
                int nc = cc + dc[dir];

                if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;

                if(dist[nr][nc] > value + grid[nr][nc]) {
                    dist[nr][nc] = value + grid[nr][nc];

                    pq.offer(new int[] {nr, nc, dist[nr][nc]});
                }
            }
        }

        return 0;
    }
}
