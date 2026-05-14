package Swea;

import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder() ;
        for(int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase);

            int N = Integer.parseInt(br.readLine());

            PriorityQueue<Long> pq = new PriorityQueue<>();

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N * 2; i++) {
                Long price = Long.parseLong(st.nextToken());

                if(pq.isEmpty()) {
                    pq.add(price);
                } else {
                    long disCount = (price / 4) * 3;

                    if(pq.peek() == disCount) {
                        sb.append(" ").append(pq.poll());
                    } else {
                        pq.add(price);
                    }
                }
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}
