package Swea;

import java.io.*;
import java.util.*;

public class Test {
    static int N, X, M, Max;
    static int[] L, R, S, ans, cage;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());

            // 햄스터 우리
            N = Integer.parseInt(st.nextToken());
            // 한 우리에 있는 햄스터 최댓값
            X = Integer.parseInt(st.nextToken());
            // 경근이의 기록 개수
            M = Integer.parseInt(st.nextToken());

            L = new int[M];
            R = new int[M];
            S = new int[M];

            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                L[i] = Integer.parseInt(st.nextToken()) - 1;
                R[i] = Integer.parseInt(st.nextToken()) - 1;
                S[i] = Integer.parseInt(st.nextToken());
            }

            Max = -1;

            cage = new int[N];
            ans = new int[N];

            dfs(0, 0);

            sb.append("#").append(testCase);
            if(Max == - 1) {
                sb.append(" ").append("-1");
            } else {
                for(int a : ans) {
                    sb.append(" ").append(a);
                }
            }
            sb.append("\n");

        }

        System.out.print(sb);
    }

    static void dfs(int depth, int sum) {
        if(depth == N) {
            if(isValid()) {
                if(sum > Max) {
                    Max = sum;
                    ans = cage.clone();
                }
            }
            return;
        }

        for(int i = 0; i <= X; i++) {
            cage[depth] = i;
            dfs(depth + 1, sum + i);
        }
    }

    static boolean isValid() {
        for(int i = 0; i < M; i++) {
            int sum = 0;

            for(int j = L[i]; j <= R[i]; j++) {
                sum += cage[j];
            }

            if(sum != S[i]) return false;
        }

        return true;
    }
}