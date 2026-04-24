package Swea.Implementation.D3.Swea_9280_진용이네주차타워;

import java.io.*;
import java.util.*;

public class 진용이네주차타워 {
    public static void main(String[] args)  throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            Queue<Integer> queue = new ArrayDeque<>();

            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] R = new int[N + 1];
            int[] W = new int[M + 1];

            boolean[] visited = new boolean[N + 1];

            for(int i = 1; i <= N; i++) {
                R[i] = Integer.parseInt(br.readLine());
            }

            for(int i = 1; i <= M; i++) {
                W[i] = Integer.parseInt(br.readLine());
            }

            int totalPrice = 0;

            for(int i = 0; i < M * 2; i++) {

                // 차량 무게에 대한 Idx
                int idx = Integer.parseInt(br.readLine());

                if(idx > 0) { // 입차
                    // 주차 가능한 곳에 대한 Idx -> R[i]
                    int inIdx = 0;
                    for(int j = 1; j <= N; j++) {
                        if(!visited[j]) {
                            inIdx = j;
                            break;
                        }
                    }

                    if(inIdx == 0) {
                        queue.add(idx);
                    } else {
                        visited[inIdx] = true;
                        map.put(idx, inIdx);
                    }
                } else { // 출차

                    // 출차 인덱스
                    int W_idx = Math.abs(idx);
                    // 주차 자리 번호
                    int R_idx = map.get(Math.abs(idx));

                    map.remove(Math.abs(idx));

                    visited[R_idx] = false;
                    totalPrice += W[W_idx] * R[R_idx];

                    // 기다리는 차가 있다면
                    if(!queue.isEmpty()) {
                        int waitingIdx = queue.poll();

                        map.put(waitingIdx, R_idx);
                        visited[R_idx] = true;
                    }
                }

            }

            sb.append("#").append(testCase).append(" ").append(totalPrice).append("\n");
        }

        System.out.println(sb);
    }
}
