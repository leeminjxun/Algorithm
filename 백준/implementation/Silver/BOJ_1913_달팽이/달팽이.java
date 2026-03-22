package 백준.implementation.Silver.BOJ_1913_달팽이;

import java.io.*;
import java.util.*;

public class 달팽이 {
    // 하, 우, 상, 좌
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];

        int x = 0;
        int y = 0;

        int targetX = 0;
        int targetY = 0;

        int num = N * N;

        int dir = 0;

        while(num > 0) {
            arr[y][x] = num;

            if (target == num) {
                targetX = x + 1;
                targetY = y + 1;
            }

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N || arr[ny][nx] != 0) {
                dir = (dir + 1) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            x = nx;
            y = ny;

            num--;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
        System.out.println(targetY + " " + targetX);


    }
}
