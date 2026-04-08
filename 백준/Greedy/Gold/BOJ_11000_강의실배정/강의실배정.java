package 백준.Greedy.Gold.BOJ_11000_강의실배정;

import java.io.*;
import java.util.*;

public class 강의실배정 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] lectures = new int[N][2];
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            lectures[i][0] = Integer.parseInt(st.nextToken());
            lectures[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lectures, (a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(lectures[0][1]);

        for(int i = 1; i < N; i++) {
            if(pq.peek() <= lectures[i][0]) {
                pq.poll();
            }

            pq.offer(lectures[i][1]);
        }

        System.out.println(pq.size());

    }
}
