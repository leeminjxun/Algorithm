package 백준.implementation.Silver.BOJ_1913_달팽이;

import java.io.*;
import java.util.*;

public class 달팽이 {
    // 하, 우, 상, 좌
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];

        int x = 0;
        int y = 0;

        int dir = 0;

        int tx = 0;
        int ty = 0;

        for(int i = N * N; i >= 1; i--) {
            arr[x][y] = i;

            if(i == target) {
                tx = x;
                ty = y;
            }

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N || arr[nx][ny] != 0) {
                dir = (dir + 1) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            x = nx;
            y = ny;
        }

        StringBuilder sb = new StringBuilder();
        for(int[] row : arr) {
            for(int col : row) {
                sb.append(col).append(" ");
            }
            sb.append("\n");
        }

        sb.append(tx + 1).append(" ").append(ty + 1);

        System.out.println(sb);
    }
}
