package programmers.Graph.BFS.Lv3;

import java.util.*;

public class 네트워크 {
    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;

        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                BFS(i, n, computers);

                answer++;
            }
        }

        return answer;
    }

    static void BFS(int start, int n, int[][] computers) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int next = 0; next < n; next++) {
                if(computers[cur][next] == 1 && !visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}