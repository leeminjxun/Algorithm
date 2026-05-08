package Swea.UnionFind.D4.Swea_7465_창용마을무리의개;

import java.io.*;
import java.util.*;

public class 창용마을무리의개수 {
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            parent = new int[N + 1];

            for(int i = 1; i <= N; i++) {
                parent[i] = i;
            }

            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            }
            Set<Integer> set = new HashSet<>();

            for(int i = 1; i <= N; i++) {
                set.add(find(i));
            }

            sb.append("#").append(testCase).append(" ");
            sb.append(set.size());
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static int find(int x) {
        if(parent[x] == x) return x;

        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if(pa != pb) {
            parent[pb] = pa;
        }
    }
}
