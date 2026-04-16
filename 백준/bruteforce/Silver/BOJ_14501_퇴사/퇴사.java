package 백준.bruteforce.Silver.BOJ_14501_퇴사;

import java.io.*;
import java.util.*;

public class 퇴사 {
    static int N, maxPrice;

    static int[] T, P;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        T = new int[N + 1];
        P = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        maxPrice = 0;

        dfs(1, 0);

        System.out.println(maxPrice);

    }

    static void dfs(int day, int price) {

        if(day >= N + 1) {
            maxPrice = Math.max(maxPrice, price);
            return;
        }

        int endTime = day + T[day];

        if(endTime <= N + 1) {
            dfs(endTime, price + P[day]);
        }

        dfs(day + 1, price);
    }
}
