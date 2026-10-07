package programmers.Graph.BFS.Lv3;

import java.util.*;

class 가장먼노드 {
    static int[] dist;

    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < edge.length; i++) {
            int u = edge[i][0];
            int v = edge[i][1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dist = new int[n + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new ArrayDeque<>();

        // node(v), distance
        q.offer(1);
        dist[1] = 0;

        while(!q.isEmpty()) {
            int v = q.poll();

            for(int u : graph.get(v)) {
                if(dist[u] == -1) {
                    dist[u] = dist[v] + 1;
                    q.offer(u);
                }
            }
        }

        int maxDist = 0;
        for(int d : dist) {
            maxDist = Math.max(maxDist, d);
        }

        int answer = 0;
        for(int d : dist) {
            if(d == maxDist) answer++;
        }

        return answer;
    }
}