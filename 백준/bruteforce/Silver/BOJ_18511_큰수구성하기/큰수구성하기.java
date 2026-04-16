package 백준.bruteforce.Silver.BOJ_18511_큰수구성하기;

import java.io.*;
import java.util.*;

public class 큰수구성하기 {
    static int N, K;
    static int max;

    static int[] number;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        number = new int[K];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        max = 0;

        dfs(0);

        System.out.println(max);

    }

    static void dfs(int current) {
        if(current > N) return;

        max = Math.max(max, current);

        for(int i = 0; i < K; i++) {
            dfs(current * 10 + number[i]);
        }
    }
}
