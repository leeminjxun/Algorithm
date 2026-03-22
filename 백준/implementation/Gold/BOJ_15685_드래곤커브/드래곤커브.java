package 백준.implementation.Gold.BOJ_15685_드래곤커브;

import java.io.*;
import java.util.*;

public class 드래곤커브 {
    static boolean[][] arr = new boolean[102][102];
    // 우, 상, 좌, 하
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        // 0
        // 0 -> 1
        // 0 1 -> 2 1
        // 0 1 2 1 -> 2 3 2 1

        // (dir + 1) % 4 공식
        StringTokenizer st;
        for(int testCase = 0; testCase < T; testCase++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            drawCurve(x, y, d, g);
        }

        System.out.println(check());
    }

    static void drawCurve(int x, int y, int d, int generation) {
        List<Integer> dirs = new ArrayList<>();
        dirs.add(d);

        for(int g = 0; g < generation; g++) {
            int size = dirs.size();

            for(int i = size - 1; i >= 0; i--) {
                dirs.add((dirs.get(i) + 1) % 4);
            }
        }

        arr[y][x] = true;
        for(int dir : dirs) {
            x += dx[dir];
            y += dy[dir];

            arr[y][x] = true;
        }
    }

    static int check() {
        int count = 0;

        for(int i = 0; i < 101; i++) {
            for(int j = 0; j < 101; j++) {
                if(arr[i][j] && arr[i+1][j] && arr[i][j+1] && arr[i+1][j+1]) {
                    count++;
                }
            }
        }

        return count;
    }
}
