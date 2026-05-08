package Swea.UnionFind.D4;

import java.io.*;
import java.util.*;

public class Swea_3289_서로소집합 {
    static int[] parent;

    static int find(int x) {
        if(parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        // 서로가 같은 집합에 있지 않다면
        if(pa != pb) {
            parent[pa] = pb;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");

            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            parent = new int[n + 1];

            for(int i = 1; i <= n; i++) {
                parent[i] = i;
            }

            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int op = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                // union
                if(op == 0) {
                    union(a, b);
                }

                else if(op == 1) {
                    if(find(a) == find(b)) sb.append("1");
                    else sb.append("0");
                }
            }

            sb.append("\n");
        }
        System.out.print(sb);
    }
}
