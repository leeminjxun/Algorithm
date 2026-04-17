package 백준.bruteforce.Silver.BOJ_16508_전공책;

import java.io.*;
import java.util.*;

public class 전공책 {
    static int N;
    static int res = Integer.MAX_VALUE;

    static int[] target, price;
    static int[][] book;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String T = br.readLine();

        target = new int[26];
        for(char c : T.toCharArray()) {
            target[c - 'A']++;
        }

        N = Integer.parseInt(br.readLine());

        price = new int[N];
        book = new int[N][26];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            price[i] = Integer.parseInt(st.nextToken());

            String W = st.nextToken();

            for(char c : W.toCharArray()) {
                book[i][c - 'A']++;
            }
        }

        dfs(0, 0, new int[26]);

        System.out.println(res == Integer.MAX_VALUE ? -1 : res);

    }

    static void dfs(int idx, int totalPrice, int[] current) {
        if(totalPrice >= res) return;

        if(check(current)) {
            res = Math.min(res, totalPrice);

            return;
        }

        if(idx == N) return;

        int[] next = current.clone();
        for(int i = 0; i < 26; i++) {
            next[i] += book[idx][i];
        }

        // book[idx] 에 해당하는 문자열 선택 함
        dfs(idx + 1, totalPrice + price[idx], next);

        // 문자열 선택 안함
        dfs(idx + 1, totalPrice, current);
    }

    static boolean check(int[] current) {

        for(int i = 0; i < 26; i++) {
            if(current[i] < target[i]) return false;
        }

        return true;
    }
}
