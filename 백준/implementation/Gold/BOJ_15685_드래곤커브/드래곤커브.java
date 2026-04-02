package 백준.implementation.Gold.BOJ_15685_드래곤커브;

import java.io.*;
import java.util.*;

public class 드래곤커브 {
    // 동, 북, 서, 남
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {1, 0, -1, 0};

    static boolean[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        map = new boolean[101][101];

        for(int testCase = 0; testCase < N; testCase++) {
            st = new StringTokenizer(br.readLine());

            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int generation = Integer.parseInt(st.nextToken());

            LinkedList<Integer> dir = new LinkedList<>();
            dir.add(d);

            for(int g = 0; g < generation; g++) {
                for(int i = dir.size() - 1; i >= 0; i--) {
                    dir.add((dir.get(i) + 1) % 4);
                }
            }

            Draw(c, r, dir);
        }

        System.out.println(checkCount());

    }

    static void Draw(int c, int r, LinkedList<Integer> dir) {
        map[r][c]= true;

        for(int i = 0; i < dir.size(); i++) {
            int d = dir.get(i);

            r += dr[d];
            c += dc[d];

            map[r][c] = true;
        }
    }

    static int checkCount() {
        int count = 0;

        for(int row  = 0; row < 100; row++) {
            for(int col = 0; col < 100; col++) {
                if(map[row][col] && map[row + 1][col] && map[row][col + 1] && map[row + 1][col + 1]) count++;
            }
        }

        return count;
    }
}
