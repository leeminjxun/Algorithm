package 백준.Greedy.Gold.BOJ_1202_보석도둑;

import java.io.*;
import java.util.*;

public class 보석도둑 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N 은 보석점에 있는 보석의 개수이다
        int N = Integer.parseInt(st.nextToken());

        // K 는 상덕이가 가지고 있는 가방 수 이다.
        int K = Integer.parseInt(st.nextToken());

        // i 번째 보석의 무게
        int[][] jewel = new int[N][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            jewel[i][0] = Integer.parseInt(st.nextToken());
            jewel[i][1] = Integer.parseInt(st.nextToken());
        }

        // maxM 은 가방 1개에 넣을 수 있는 최대 보석의 무게
        int[] C = new int[K];

        for(int i = 0; i < K; i++) {
            C[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewel, (a, b) -> {
            return a[0] - b[0];
        });

        Arrays.sort(C);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int jewelIdx = 0;
        long maxSum = 0;

        for(int i = 0; i < K; i++) {
            while(jewelIdx < N && jewel[jewelIdx][0] <= C[i]) {
                pq.add(jewel[jewelIdx][1]);

                jewelIdx++;
            }

            if(!pq.isEmpty()) {
                maxSum += pq.poll();
            }
        }

        System.out.println(maxSum);

    }
}
