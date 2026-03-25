package 백준.implementation.Gold.BOJ_17144_미세먼지안녕;

import java.io.*;
import java.util.*;

public class 미세먼지안녕 {
    static int r, c;

    static int[][] room;

    // 동 남 서 북 (시계 방향)
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static int topCleaner, downCleaner;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        room = new int[r][c];

        topCleaner = -1;
        downCleaner = -1;

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());

                // 0, 1 인덱스에 담김
                if (room[i][j] == -1 && topCleaner == -1) {
                    topCleaner = i;
                    downCleaner = i + 1;
                }
            }
        }

        for (int time = 0; time < T; time++) {
            diffusion();
            swap();
        }

        int result = check();

        System.out.println(result);
    }

    static void diffusion() {

        int[][] copy = new int[r][c];
        for(int i = 0; i < r; i++) copy[i] = room[i].clone();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (copy[i][j] != -1 && copy[i][j] != 0) {

                    int amount = copy[i][j] / 5;

                    // 확산된 방향 개수
                    int cnt = 0;

                    for (int dir = 0; dir < 4; dir++) {
                        int nextR = i + dr[dir];
                        int nextC = j + dc[dir];

                        if (0 > nextR || nextR >= r || 0 > nextC || nextC >= c) continue;
                        if (room[nextR][nextC] == -1) continue;

                        room[nextR][nextC] += amount;

                        cnt++;
                    }

                    room[i][j] -= amount * cnt;
                }
            }
        }
    }

    static void swap() {
        // topCleaner 위 쪽 방향
        for (int row = topCleaner - 1; row > 0; row--) room[row][0] = room[row - 1][0];

        // 위쪽 방향에서 오른쪽으로 이동
        for (int col = 0; col < c - 1; col++) room[0][col] = room[0][col + 1];

        // 오른쪽 방향에서 아래로 이동
        for (int row = 0; row < topCleaner; row++) room[row][c - 1] = room[row + 1][c - 1];

        // 아래 방향에서 왼쪽 방향으로 이동
        for (int col = c - 1; col > 0; col--) room[topCleaner][col] = room[topCleaner][col - 1];

        // 공기 청정기 바로 옆의 칸은 0
        room[topCleaner][1] = 0;

        // downCleaner 아래 쪽 방향
        for (int row = downCleaner + 1; row < r - 1; row++) room[row][0] = room[row + 1][0];

        // 아래쪽 방향에서 오른쪽으로 이동
        for (int col = 0; col < c - 1; col++) room[r - 1][col] = room[r - 1][col + 1];

        // 오른쪽 방향에서 위로 이동
        for (int row = r - 1; row > downCleaner; row--) room[row][c - 1] = room[row - 1][c - 1];

        // 위 방향에서 왼쪽으로 이동
        for (int col = c - 1; col > 0; col--) room[downCleaner][col] = room[downCleaner][col - 1];

        room[downCleaner][1] = 0;

    }

    static int check() {
        int total = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(room[i][j] > 0) {
                    total += room[i][j];
                }
            }
        }

        return total;
    }

}
