package Swea.BackTracking.D4.Swea_3234_준환이의양팔저울;

import java.io.*;
import java.util.*;

public class 준환이의양팔저울 {
    static int N, total;
    static int cnt;

    static int[] weight;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(br.readLine());

            weight = new int[N];
            visited = new boolean[N];

            total = 0;

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                weight[i] = Integer.parseInt(st.nextToken());
                total += weight[i];
            }

            cnt = 0;

            dfs(0, 0, 0);

            sb.append("#").append(testCase).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int left, int right, int depth) {
        if(left < right) return;

        if(depth == N) {
            cnt++;
            return;
        }

        if(left >= total - left) {
            cnt += factorial(N - depth) * (int) Math.pow(2, N - depth);
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(left + weight[i], right, depth + 1);
                dfs(left, right + weight[i], depth + 1);
                visited[i] = false;
            }
        }
    }

    static int factorial(int n) {
        int result = 1;

        for(int i = 1; i <= n; i++) {
            result *= i;
        }

        return result;
    }
}