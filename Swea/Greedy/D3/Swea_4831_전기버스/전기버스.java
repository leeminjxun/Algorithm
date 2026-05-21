package Swea.Greedy.D3.Swea_4831_전기버스;

import java.io.*;
import java.util.*;

public class 전기버스 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());

            int K = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] charge = new int[M];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++) {
                charge[i] = Integer.parseInt(st.nextToken());
            }

            int current = 0;
            int cnt = 0;
            int idx = 0;

            // 현재 위치에서 버스가 이동 했을 때의 위치가 N 보다 작은 경우 반복
            // -> 현재 위치에서 버스는 종점까지 갈 수 없다
            while(current + K < N) {
                // next 는 버스가 현재의 충전량으로 가능한 거리를 하나 씩 비교한다.
                int next = current;

                // 현재 모든 정류소를 탐색하지 않았고, 현재 가리키는 충전기가 있는 정류장이 버스가 이동 가능한 정류장보다 뒤에 있거나 같은 경우
                while(idx < M && charge[idx] <= current + K) {
                    // 현재 충전량으로 가능한 다음 정류소 위치
                    next = charge[idx];
                    idx ++;
                }

                // 반복문이 끝났을 때, next 와 current 의 차이가 없다면 둘 중 하나이다.
                // 1. 정류소 내의 충전기 간격을 잘못 설치해, 버스가 다음 위치까지 가지 못한 경우
                // 2. 충전량이 매우 커 한번의 충전으로 종점까지 간 경우
                if(next == current) {
                    cnt = 0;
                    break;
                }

                current = next;
                cnt++;
            }

            sb.append("#").append(testCase).append(" ").append(cnt).append("\n");
        }

        System.out.print(sb);
    }
}
