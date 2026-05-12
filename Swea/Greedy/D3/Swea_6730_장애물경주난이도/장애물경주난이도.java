package Swea.Greedy.D3.Swea_6730_장애물경주난이도;

import java.io.*;
import java.util.*;

public class 장애물경주난이도 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> up = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> down = new PriorityQueue<>(Collections.reverseOrder());

            int[] block = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                block[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 1; i < N; i++) {
                if(block[i - 1] > block[i]) {
                    down.add(block[i - 1] - block[i]);
                }

                if(block[i - 1] < block[i]) {
                    up.add(block[i] - block[i - 1]);
                }
            }

            sb.append("#").append(testCase).append(" ");
            if(up.isEmpty()) sb.append("0");
            else sb.append(up.peek());
            sb.append(" ");
            if(down.isEmpty()) sb.append("0");
            else sb.append(down.peek());
            sb.append(" ");

            sb.append("\n");
        }

        System.out.print(sb);
    }
}
