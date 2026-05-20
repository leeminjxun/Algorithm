package Swea;

import java.io.*;
import java.util.*;

public class Test {
    static int totalSum, win, lose;
    static int[] qyu_card, in_card;

    static int[] factorial = new int[10];

    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        setFactorial();

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());

            qyu_card = new int[9];
            in_card = new int[9];
            boolean[] card = new boolean[19];

            for(int i = 0; i < 9; i++) {
                qyu_card[i] = Integer.parseInt(st.nextToken());
                card[qyu_card[i]] = true;
            }

            totalSum = 0;

            int idx = 0;
            for(int i = 1; i <= 18; i++) {
                if(!card[i]) in_card[idx++] = i;
                totalSum += i;
            }

            visited = new boolean[9];

            dfs(0, 0, 0);

            sb.append("#").append(testCase).append(" ").append(win).append(" ").append(lose).append("\n");

        }

        System.out.print(sb);
    }
    // 전체 경우의 수 362880
    static void dfs(int depth, int in_score, int qyu_score) {
        if(in_score > 85) {
            lose += factorial[9 - depth];
            return ;
        }

        if(qyu_score > 85) {
            win += factorial[9 - depth];
            return ;
        }

        if(depth == 9) {
            if(qyu_score < in_score) lose++;

            if(qyu_score > in_score) win++;

            return;
        }

        for(int i = 0; i < 9; i++) {
            if(!visited[i]) {
                visited[i] = true;

                if(qyu_card[depth] > in_card[i]) dfs(depth + 1, in_score, qyu_score + qyu_card[depth] + in_card[i]);
                else dfs(depth + 1, in_score + qyu_card[depth] + in_card[i], qyu_score);

                visited[i] = false;
            }
        }
    }

    static void setFactorial() {
        factorial[0] = 1;

        for(int i = 1; i <= 9; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }

}