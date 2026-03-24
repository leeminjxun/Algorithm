package 백준.Queue.Silver.BOJ_1966_프린터큐;

import java.io.*;
import java.util.*;

public class 프린터큐 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 0; testCase < T; testCase++) {

            // int 형 배열 값을 가지는 queue 생성
            Queue<int[]> queue = new ArrayDeque<>();

            st = new StringTokenizer(br.readLine());

            // 문서의 개수
            int N = Integer.parseInt(st.nextToken());
            // 출력 문서의 queue 내의 현재 위치 값
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                // 0번 index : 우선 순위 값
                // 1번 index : 파일 순번 값
                queue.add(new int[]{Integer.parseInt(st.nextToken()), i});
            }

            int cnt = 0;

            while(!queue.isEmpty()) {
                int[] cur = queue.poll();

                // 현재 문서의 우선순위 보다 더 높은 우선순위가 있음을 탐색
                boolean isHigher = false;
                for(int[] doc : queue) {
                    // 더 높은 우선순위를 가지는 문서가 있다면 break
                    if(doc[0] > cur[0]) {
                        isHigher = true;
                        break;
                    }
                }

                // 더 높은 우선순위가 있으므로 현재의 문서는 다시 queue 로 이동
                if(isHigher) {
                    queue.add(cur);
                } else {
                    // 현재 문서가 최고 우선순위를 가지는 경우
                    cnt++;

                    // 현재 문서를 나타내는 cur 배열의 1 번 인덱스(파일 순번 값) 이 M(탐색 문서) 과 같을 경우 종료
                    if(cur[1] == M) {
                        sb.append(cnt).append("\n");

                        break;
                    }
                }
            }
        }

        System.out.println(sb);
    }
}
