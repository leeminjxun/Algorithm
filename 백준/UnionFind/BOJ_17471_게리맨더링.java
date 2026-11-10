package 백준.UnionFind;

import java.io.*;
import java.util.*;

public class BOJ_17471_게리맨더링 {
    static int N, aCount, bCount, minRes;
    static int[] population;
    static List<Integer>[] linkedNode;
    // A 에 포함되는 idx
    static boolean[] group;

    static int[] parent;

    static int find(int x) {
        if(parent[x] == x) return x;

        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if(pa != pb) parent[pa] = pb;

        return;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        population = new int[N];
        linkedNode = new ArrayList[N];
        group = new boolean[N];
        parent = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());

            linkedNode[i] = new ArrayList<>();

            // 배열 인덱스에 맞춰 넣는다.
            for(int j = 0; j < cnt; j++) linkedNode[i].add(Integer.parseInt(st.nextToken()) - 1);
        }

        minRes = Integer.MAX_VALUE;

        dfs(0);

        System.out.print(minRes == Integer.MAX_VALUE ? -1 : minRes);
    }

    static void dfs(int idx) {
        if(idx == N) {
            check();
            return ;
        }

        group[idx] = true;
        dfs(idx + 1);

        group[idx] = false;
        dfs(idx + 1);
    }

    static void check() {
        // A 와 B 그룹에 대한 지역이 둘 다 존재하는지 확인한다.
        boolean hasA = false, hasB = false;
        for(int i = 0; i < N; i++) {
            if(group[i]) hasA = true;
            else hasB = true;
        }

        // 둘 중 하나라도 없으면, 조건 충족 X
        if(!hasA || !hasB) return;

        for(int i = 0; i < N; i++) parent[i] = i;

        // 조건에 따른 그룹화한 노드 연결
        // 1. 두 node 가 같은 그룹의 선거구 인 경우
        // 2. 두 node 가 연결된 경우
        for(int u = 0; u < N; u++) {
            for(int v : linkedNode[u]) {
                if(group[u] == group[v]) union(u, v);
            }
        }

        // 노드 연결에 따른 그룹 개수 Check
        Set<Integer> groupCount = new HashSet<>();

        // 모든 자식 노드는 부모 노드를 따라가기에, find(i) 를 통해 부모 노드의 개수를 구할 수 있음
        for(int i = 0; i < N; i++) {
            groupCount.add(find(i));
        }
        if(groupCount.size() != 2) return;

        aCount = 0; bCount = 0;
        for(int i = 0; i < N; i++) {
            if(group[i]) aCount += population[i];
            else bCount += population[i];
        }

        minRes = Math.min(minRes, Math.abs(aCount - bCount));

        return;
    }
}
