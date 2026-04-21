package 백준.BackTracking.Silver.BOJ_14888_연산자끼워넣기;

import java.io.*;
import java.util.*;

public class 연산자끼워넣기 {

    static int plus, minus, multi, divide;

    static int N;

    static int[] num;

    static int max, min;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        num = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        plus = Integer.parseInt(st.nextToken());
        minus = Integer.parseInt(st.nextToken());
        multi = Integer.parseInt(st.nextToken());
        divide = Integer.parseInt(st.nextToken());


        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        dfs(1, num[0]);

        System.out.println(max);
        System.out.println(min);

    }

    static void dfs(int depth, int result) {
        if(depth == N) {
            max = Math.max(max, result);
            min = Math.min(min, result);
        }

        if(plus > 0) {
            plus--;
            dfs(depth + 1, result + num[depth]);
            plus++;
        }

        if(minus > 0) {
            minus--;
            dfs(depth + 1, result - num[depth]);
            minus++;
        }

        if(multi > 0) {
            multi--;
            dfs(depth + 1, result * num[depth]);
            multi++;
        }

        if(divide > 0) {
            divide--;
            dfs(depth + 1, result / num[depth]);
            divide++;
        }
    }
}
