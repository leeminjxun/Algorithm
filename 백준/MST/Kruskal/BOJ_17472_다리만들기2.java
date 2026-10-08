package 백준.MST.Kruskal;

import java.io.*;
import java.util.*;

public class BOJ_17472_다리만들기2 {

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};

    static int N, M;

    static int[][] map;
    static boolean[][] visited;

    static PriorityQueue<int[]> edges;

    static int[] parent;

    static int find(int x) {
        if(parent[x] == x) return parent[x];

        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB) return false;

        parent[rootA] = rootB;

        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int islandNumber = 1;

        // 각 섬에 넘버링
        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++) {
                if(map[i][j] != 0 && !visited[i][j]) BFS(i, j, islandNumber++);
            }

        // new int[] {r, c, weight}
        edges = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++) {
                if(map[i][j] != 0) searchIsland(i, j);
            }

        islandNumber--;

        parent = new int[islandNumber + 1];
        for(int i = 1; i <= islandNumber; i++) {
            parent[i] = i;
        }

        int res = 0;
        int usedEdge = 0;

        while(!edges.isEmpty()) {
            int[] cur = edges.poll();

            int v = cur[0], u = cur[1], weight = cur[2];

            if(union(u, v)) {
                res += weight;
                usedEdge++;
            }
        }

        // 방문 노드 수가 섬의 개수와 다르다면, 섬 연결이 되지 않았으므로 -1
        System.out.println(islandNumber - 1 == usedEdge ? res : -1);
    }

    static void searchIsland(int r, int c) {
        for(int dir = 0; dir < 4; dir++) {
            int nr = r + dr[dir], nc = c + dc[dir];

            if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
            if(map[nr][nc] != 0) continue;

            int weight = 1;

            while(true) {
                nr += dr[dir]; nc += dc[dir];

                if(nr < 0 || nc < 0 || nr >= N || nc >= M) break;
                // 섬이 나타나면 멈춤
                if(map[nr][nc] != 0) {
                    // 길이가 2 이며, 시작 섬과 같은 섬이지 않아야함
                    if(weight >= 2 && map[nr][nc] != map[r][c]) {
                        int firstLabel = map[r][c];
                        int secondLabel = map[nr][nc];

                        edges.offer(new int[] {firstLabel, secondLabel, weight});
                    }

                    // 떨어진 길이가 1인 섬이 있다면, 포함시키지 않음
                    break;
                }

                weight++;
            }
        }
    }

    static void BFS(int r, int c, int label) {
        map[r][c] = label;

        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {r, c});
        visited[r][c] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0], cc = cur[1];

            for(int dir = 0; dir < 4; dir++) {
                int nr = cr + dr[dir], nc = cc + dc[dir];

                if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if(visited[nr][nc] || map[nr][nc] == 0) continue;

                map[nr][nc] = label;

                q.offer(new int[] {nr, nc});
                visited[nr][nc] = true;
            }
        }
    }
}
