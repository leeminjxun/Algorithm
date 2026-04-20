package Swea.Greedy.D3.Swea_1860_진기의최고급붕어빵;

import java.io.*;
import java.util.*;

// 더 좋은 풀이
public class 진기의최고급붕어빵2 {
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

            int[] P = new int[N + 1];

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++) {
                P[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(P);

            boolean isPossible = true;
            for(int i = 1; i <= N; i++) {
                int time = P[i];

                int bread = (time / M) * K;

                if(bread < i) {
                    isPossible = false;
                    break;
                }

            }

            sb.append("#").append(testCase).append(" ")
                    .append(isPossible ? "Possible" : "Impossible")
                    .append("\n");

        }

        System.out.println(sb);

    }
}
