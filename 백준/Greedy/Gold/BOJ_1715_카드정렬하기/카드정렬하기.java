package 백준.Greedy.Gold.BOJ_1715_카드정렬하기;

import java.io.*;
import java.util.*;

public class 카드정렬하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++) {
            pq.add(Long.parseLong(br.readLine()));
        }
        long totalSum = 0;

        while(pq.size() > 1) {
            long first = pq.poll();
            long second = pq.poll();

            long currentSum = first + second;
            totalSum += currentSum;

            pq.add(currentSum);
        }

        System.out.println(totalSum);
    }
}
