package Swea.graph.DFS;

import java.io.*;
import java.util.*;

public class Swea_1494_사랑의카운슬러 {
    static int N;
    static long sumX, sumY, res;
    static long[] X, Y;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(br.readLine());

            X = new long[N]; Y = new long[N];
            sumX = 0; sumY = 0;

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                X[i] = Long.parseLong(st.nextToken());
                Y[i] = Long.parseLong(st.nextToken());

                sumX += X[i];
                sumY += Y[i];
            }

            res = Long.MAX_VALUE;

            DFS(0, 0, 0, 0);

            sb.append("#").append(testCase).append(" ").append(res).append("\n");
        }

        System.out.print(sb);
    }

    /**
     *
     * @param idx : 현재 바라보고 있는 인덱스
     * @param cnt : + 집합 에 포함시킨 짝의 개수
     * @param cx : + 집합에 포함된 x 벡터의 합
     * @param cy : + 집합에 포함된 y 벡터의 합
     */
    static void DFS(int idx, int cnt, long cx, long cy) {
        if(cnt == N / 2) {
            // + 집합에서 - 집합을 뺸다.
            long vx = cx - (sumX - cx);
            long vy = cy - (sumY - cy);
            res = Math.min(res, vx * vx + vy * vy);

            return;
        }

        if(idx == N) return;

        // 지금까지 고르지 않은 값이 N / 2 보다 클 때
        if(idx - cnt > N / 2) return;

        DFS(idx + 1, cnt + 1, cx + X[idx], cy + Y[idx]);
        DFS(idx + 1, cnt, cx, cy);
    }
}
