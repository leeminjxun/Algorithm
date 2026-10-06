package Swea.MST.D4;

import java.io.*;
import java.util.*;

public class Swea_1251_하나로 {
    static int N;

    static int[] x, y;

    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(br.readLine());

            x = new int[N];
            y = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) x[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) y[i] = Integer.parseInt(st.nextToken());

            Double E = Double.parseDouble(br.readLine());

            long totalDistance = 0;
            int count = 0;

            visited = new boolean[N];

            PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));

            pq.offer(new long[] {0, 0});

            while(!pq.isEmpty() && count < N) {
                long[] cur = pq.poll();

                int v = (int) cur[0];
                long value = cur[1];

                if(visited[v]) continue;

                visited[v] = true;
                totalDistance += value;
                count++;

                int x1 = x[v], y1 = y[v];

                for(int u = 0; u < N; u++) {
                    if(visited[u]) continue;

                    int x2 = x[u], y2 = y[u];

                    long dx = x2 - x1, dy = y2 - y1;
                    pq.offer(new long[] { u, dx * dx + dy * dy });
                }
            }

            sb.append("#").append(testCase).append(" ").append(Math.round(E * totalDistance)).append("\n");
        }

        System.out.print(sb);
    }
}
