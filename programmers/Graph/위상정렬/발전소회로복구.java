package programmers.Graph.위상정렬;

import java.util.*;

class 발전소회로복구 {
    static int[] dr = {-1, 1, 0, 0, 0, 0};
    static int[] dc = {0, 0, -1, 1, 0, 0};
    static int[] dh = {0, 0, 0, 0, -1, 1};

    // 패널 수, gird 의 row, col 수
    static int n, H, R, C;
    // 위상 정렬 그래프
    static List<Integer>[] graph;
    // 현재 연결된 노드 개수
    static int[] indegree;
    // 활성화된 패널
    static boolean[] activated;

    // 패널 사이의 활성화표
    static int[][] d;

    static String[] grid;
    static int[][] panels;

    // 모든 패널을 활성하는데 걸리는 최소시간 -> return
    static int minTime;

    // 가지치기를 위한 best 배열
    static int[][] best;

    /**
     * h : 발전소 높이
     * grid : 발전소 n * m 격자
     * panels : 패널 위치
     * seqs : 안전 순서
     **/
    public int solution(int h, String[] g, int[][] p, int[][] seqs) {
        grid = g;

        n = p.length;
        H = h;
        R = grid.length;
        C = grid[0].length();

        panels = new int[n][3];
        for (int i = 0; i < n; i++) {
            panels[i][0] = p[i][0] - 1;
            panels[i][1] = p[i][1] - 1;
            panels[i][2] = p[i][2] - 1;
        }

        graph = new ArrayList[n];
        indegree = new int[n];
        activated = new boolean[n];

        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for(int[] seq : seqs) {
            int a = seq[0] - 1, b = seq[1] - 1;

            graph[a].add(b);
            indegree[b]++;
        }

        d = new int[n][n];
        for(int i = 0; i < n; i++) {
            int[][][] dist = BFS(i);
            for(int j = 0; j < n; j++) {
                d[i][j] = dist[panels[j][0]][panels[j][1]][panels[j][2]];
            }
        }

        best = new int[1 << n][n];
        for(int[] row : best) Arrays.fill(row, Integer.MAX_VALUE);

        minTime = Integer.MAX_VALUE;

        DFS(0, 0, 0, 0);

        return minTime;
    }

    // 위상정렬을 기준으로 현재 도달 가능한 패널을 탐색한다.
    static void DFS(int depth, int cur, int time, int state) {
        if(time >= minTime) return;

        // 1 > 2 > 3 으로 이미 왔을 경우
        // 1 > 3 > 2 등으로 온 경로를 차단한다.
        if(time >= best[state][cur]) return;
        best[state][cur] = time;

        if(depth == n) {
            minTime = Math.min(minTime, time);

            return;
        }

        for(int a = 0; a < n; a++) {
            if(activated[a] || indegree[a] != 0) continue;
            if(d[cur][a] < 0) continue;

            activated[a] = true;
            for(int b : graph[a]) indegree[b]--;

            DFS(depth + 1, a, time + d[cur][a], state + (1 << a));

            activated[a] = false;
            for(int b : graph[a]) indegree[b]++;
        }
    }

    // a 번 패널에서 b 번 패널으로 가는 최단 경로를 구한다.
    static int[][][] BFS(int a) {
        int[][][] dist = new int[H][R][C];

        for(int[][] layer : dist)
            for(int[] row : layer) Arrays.fill(row, -1);

        int[] s = panels[a];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        dist[s[0]][s[1]][s[2]] = 0;

        q.add(new int[] {s[0], s[1], s[2]});

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            int h = cur[0], r = cur[1], c = cur[2];

            for(int dir = 0; dir < 6; dir++) {
                if(dir >= 4 && grid[r].charAt(c) != '@') continue;
                int nr = r + dr[dir];
                int nc = c + dc[dir];
                int nh = h + dh[dir];

                if(nh < 0 || nh >= H || nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                if(dist[nh][nr][nc] != -1) continue;
                if(grid[nr].charAt(nc) == '#') continue;

                dist[nh][nr][nc] = dist[h][r][c] + 1;
                q.add(new int[] {nh, nr, nc});
            }
        }

        return dist;
    }
}
