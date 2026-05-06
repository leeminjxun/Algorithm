package Swea.BackTracking.D3.Swea_6808_규영이와인영이의카드게임;

import java.io.*;
import java.util.*;

public class 규영이와인영이의카드게임 {
    static int[] gyu_arr;
    static int[] in_arr;

    static int win, lose;

    static boolean[] visited;

    static int[] factorial = new int[10];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        initFactorial();

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");

            st = new StringTokenizer(br.readLine());

            gyu_arr = new int[9];
            in_arr = new int[9];

            boolean[] inPossible = new boolean[19];
            for(int i = 0; i < 9; i++) {
                gyu_arr[i] = Integer.parseInt(st.nextToken());
                inPossible[gyu_arr[i]] = true;
            }

            int idx = 0;
            for(int i = 1; i <= 18; i++) {
                if(!inPossible[i]) in_arr[idx++] = i;
            }

            visited = new boolean[9];

            win = 0;
            lose = 0;
            dfs(0, 0, 0);

            sb.append(win).append(" ").append(lose);

            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int depth, int gyuScore, int inScore) {
        if(gyuScore > 85) {
            win += factorial[9 - depth];
            return;
        }

        if(inScore > 85) {
            lose += factorial[9 - depth];
            return;
        }

        if(depth == 9) {
            if(gyuScore > inScore) win++;
            else if(gyuScore < inScore) lose++;
            return;
        }

        for(int i = 0; i < 9; i++) {
            if(!visited[i]) {
                visited[i] = true;

                if(in_arr[i] > gyu_arr[depth]) {
                    dfs(depth + 1, gyuScore, inScore + (in_arr[i] + gyu_arr[depth]));
                }
                else if(in_arr[i] < gyu_arr[depth]) {
                    dfs(depth + 1, gyuScore + (in_arr[i] + gyu_arr[depth]), inScore);
                }

                visited[i] = false;
            }
        }
    }

    static void initFactorial() {
        factorial[0] = 1;

        for(int i = 1; i <= 9; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }
}
