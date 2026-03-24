package 백준.implementation.Gold.BOJ_14503_로봇청소기;

import java.io.*;
import java.util.*;

public class 로봇청소기 {

    // 북, 동, 남, 서 ()
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] room = new int[N][M];

        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for(int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col = 0; col < M; col++) {
                room[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        // 현재 칸이 청소되지 않았을 경우, 청소 함

        // 현재 칸 주변 4칸 중 청소된 구간일 경우
        // 1. 바라보는 방향을 유지하고, 한칸 후진 하여 청소한다.
        // 2. 바라보는 방향 뒤쪽 칸이 벽이라면 작동을 중지

        // 현재 칸 주변 4칸 중 청소되지 않은 구간이 있을 경우
        // 1. 반시계 방향 90도 회전
        // 2. 바라보는 방향 기준으로 앞 쪽 칸이 빈 칸일 경우 전진
        // 청소한다.

        int cnt = 0;

        while(true) {

            if(room[r][c] == 0) {
                room[r][c] = 2;
                cnt += 1;
            }

            // 다음 방향 지정 로직
            boolean found = false;
            int nextDir = d;
            for(int i = 0; i < 4; i++) {

                // 반시계 방향으로 현재 방향 이동
                nextDir = (nextDir + 3) % 4;

                // 다음 방향 앞 쪽 구간이 0 일 경우
                if(room[r + dy[nextDir]][c + dx[nextDir]] == 0) {
                    found = true;
                    break;
                }
            }

            // nextDir == d 일 경우는 반시계 방향 회전을 전부 진행 -> 현재 값 주변에 청소가 안된 지역은 없음
            // -> 청소가 된 지역 or 벽이 있는 경우
            if(!found) {
                // 뒤로 이동항 방향 계산, 방향 d 는 현재 값 유지
                int dirBack = (d + 2) % 4;

                // 바라보는 방향 뒤 쪽 칸이 벽이라면 작동 중지
                if(room[r + dy[dirBack]][c + dx[dirBack]] == 1) break;

                // 바라보는 방향 뒤로 이동
                r += dy[dirBack];
                c += dx[dirBack];
            } else {

                r += dy[nextDir];
                c += dx[nextDir];
                d = nextDir;
            }

        }

        System.out.println(cnt);


    }
}


