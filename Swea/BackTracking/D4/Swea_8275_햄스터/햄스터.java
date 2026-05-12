package Swea.BackTracking.D4.Swea_8275_햄스터;

import java.io.*;
import java.util.*;

public class 햄스터 {
    static int N, X, M, maxSum;

    static int[] L, R, S, cage, ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            L = new int[M];
            R = new int[M];
            S = new int[M];

            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                // 인덱스 계산 편의를 위해 -1
                L[i] = Integer.parseInt(st.nextToken()) - 1;
                R[i] = Integer.parseInt(st.nextToken()) - 1;
                S[i] = Integer.parseInt(st.nextToken());
            }

            cage = new int[N];
            ans = new int[N];

            maxSum = -1;

            dfs(0, 0);

            sb.append("#").append(testCase);
            if(maxSum == -1) {
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
                if(sum > maxSum) {
                    maxSum = sum;
                    ans = cage.clone();
                }
            }
            return ;
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
