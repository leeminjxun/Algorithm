package 백준.implementation.Silver;

import java.io.*;

public class BOJ_3085_사탕게임 {
    static int N;
    static int maxCount;
    static char[][] candy;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        maxCount = 0;
        candy = new char[N][N];

        for(int i = 0; i < N; i++) {
            String S = br.readLine();
            for(int j = 0; j < N; j++) {

                candy[i][j] = S.charAt(j);

            }
        }

        for(int row = 0; row < N; row++) {
            for(int col = 0; col < N; col++) {
                if(row + 1 < N) {
                    swap(row, col, row + 1, col);
                    check();
                    swap(row, col, row + 1, col);
                }

                if(col + 1 < N) {
                    swap(row, col, row, col + 1);
                    check();
                    swap(row, col, row, col + 1);
                }
            }
        }

        System.out.println(maxCount);

    }

    // 인접한 두 사탕 값 바꾸기 함수
    static void swap(int x1, int y1, int x2, int y2) {
        char temp = candy[x1][y1];
        candy[x1][y1] = candy[x2][y2];
        candy[x2][y2] = temp;
    }

    // 행 열, maxCount Check 함수
    static void check() {

        // 가로 (행) 검사
        for(int row = 0; row < N; row++) {
            int count = 1;

            for(int col = 0; col < N - 1; col++) {
                if(candy[row][col] == candy[row][col + 1]) {
                    count++;
                } else {
                    count = 1;
                }

                maxCount = Math.max(count, maxCount);
            }
        }

        // 세로 (열) 검사
        for(int col = 0; col < N; col++) {
            int count = 0;
            for(int row = 0; row < N - 1; row++) {
                if(candy[row][col] == candy[row + 1][col]) {
                    count++;
                } else {
                    count = 1;
                }

                maxCount = Math.max(count, maxCount);
            }
        }
    }
}
