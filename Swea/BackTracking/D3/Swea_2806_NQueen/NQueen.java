package Swea.BackTracking.D3.Swea_2806_NQueen;

import java.io.*;

public class NQueen {
    static int N;
    static int[] visited;

    static int res;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(br.readLine());

            visited = new int[N];

            res = 0;
            dfs(0);

            sb.append("#").append(testCase).append(" ").append(res).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int row) {
        if(row == N) {
            res++;
            return;
        }

        for(int col = 0; col < N; col++) {
            if(check(row, col)) {
                // visited 배열은 덮어쓰기로, 분기에 따른 초기화 X
                visited[row] = col;
                dfs(row + 1);
            }
        }

    }

    static boolean check(int row, int col) {
        // visited[row] 에서 row 는 0 부터 오름차순 증가하기에, row 이상의 행은 비교할 필요가 없다.
        for(int i = 0; i < row; i++) {
            if(visited[i] == col) return false;

            if(Math.abs(row - i) == Math.abs(col - visited[i])) return false;
        }

        return true;
    }


}
