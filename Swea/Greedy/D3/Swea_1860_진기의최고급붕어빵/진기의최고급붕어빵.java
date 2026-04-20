package Swea.Greedy.D3.Swea_1860_진기의최고급붕어빵;

import java.io.*;
import java.util.*;

public class 진기의최고급붕어빵 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());

            // 붕어빵을 받는 사람 수
            int N = Integer.parseInt(st.nextToken());

            // 붕어빵을 만드는 시간
            int M = Integer.parseInt(st.nextToken());

            // M 초 동안 만들 수 있는 붕어빵의 수
            int K = Integer.parseInt(st.nextToken());

            // 붕어빵을 받는 사람들이 도착하는 시간
            PriorityQueue<Integer> P = new PriorityQueue<>();

            // what's topic
            // 붕어빵을 받는 사람들이 도착하는 시간에 정확하게 붕어빵 1개를 받을 수 있는지 check
            // 받을 수 있다면 possible, 받을 수 없다면 impossible

            // 접근법 :
            // 우선적으로 시간을 기준으로 비교를 한다.
            // 붕어빵은 누적된다. M = 2, K = 2 일 때 2초마다 붕어빵 2개를 만든다. 1초에는 붕어빵 1개도 못만든다.
            // 1초 단위로 비교하며, 반복문을 돌렸을 때 i % M == 0 일 때 붕어빵 을 K 개씩 추가한다.

            int lastPerson = 0;

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                int person = Integer.parseInt(st.nextToken());

                P.add(person);

                lastPerson = Math.max(lastPerson, person);
            }

            int B = 0;
            boolean isPossible = true;

            for(int i = 1; i <= lastPerson; i++) {
                if(P.peek() == 0) {
                    isPossible = false;
                    break;
                }

                if(i % M == 0) B += K;

                if(P.peek() == i) {
                    if(B > 0) {
                        P.poll();
                        B--;
                    } else {
                        isPossible = false;
                        break;
                    }
                }
            }

            sb.append("#" + testCase + " ").append(isPossible ? "Possible" : "Impossible").append("\n");
        }

        System.out.println(sb);
    }
}
