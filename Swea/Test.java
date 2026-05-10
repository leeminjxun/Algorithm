package Swea;

import java.io.*;
import java.util.*;

public class Test {
    static int N, res, totalSum;
    static int[] arr;

    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(br.readLine());

            arr = new int[N];
            visited = new boolean[N];

            totalSum = 0;

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                totalSum += arr[i];
            }

            res = 0;

            dfs(0, 0, 0);

            sb.append("#").append(testCase).append(" ").append(res).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int depth, int left, int right) {
        if(right > left) return;

        if(depth == N) {
            res++;
            return;
        }

        if(left >= totalSum - left) {
            res += factorial(N - depth) * (int) Math.pow(2, N - depth);
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, left + arr[i], right);
                dfs(depth + 1, left, right + arr[i]);
                visited[i] = false;
            }
        }
    }

    static int factorial(int n) {
        int fac = 1;

        for(int i = 1; i <= n; i++) {
            fac *= i;
        }

        return fac;
    }

}
