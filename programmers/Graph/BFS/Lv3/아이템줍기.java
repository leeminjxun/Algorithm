package programmers.Graph.BFS.Lv3;

import java.util.*;

public class 아이템줍기 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static boolean[][] grid, visited;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        int mx = 0;
        int my = 0;

        for(int[] rec : rectangle) {
            mx = Math.max(mx, rec[2]) * 2;
            my = Math.max(my, rec[3]) * 2;
        }

        grid = new boolean[mx + 1][my + 1];
        visited = new boolean[mx + 1][my + 1];

        for(int[] rec : rectangle) {
            int sx = rec[0] * 2, sy = rec[1] * 2,
                    ex = rec[2] * 2, ey = rec[3] * 2;

            for(int x = sx; x <= ex; x++) {
                for(int y = sy; y <= ey; y++) {
                    grid[x][y] = true;
                }
            }
        }

        for(int[] rec : rectangle) {
            int sx = rec[0] * 2, sy = rec[1] * 2,
                    ex = rec[2] * 2, ey = rec[3] * 2;

            for(int x = sx + 1; x < ex; x++) {
                for(int y = sy + 1; y < ey; y++) {
                    grid[x][y] = false;
                }
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });

        pq.add(new int[] {characterX * 2, characterY * 2, 0});
        visited[characterX * 2][characterY * 2] = true;

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();

            int cx = cur[0], cy = cur[1], value = cur[2];

            if(cx == itemX * 2 && cy == itemY * 2) return value / 2;

            for(int dir = 0; dir < 4; dir++) {
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];

                if(nx < 0 || ny < 0 || nx > mx || ny > my) continue;
                if(visited[nx][ny] || !grid[nx][ny]) continue;

                pq.add(new int[] {nx, ny, value + 1});
                visited[nx][ny] = true;
            }
        }

        return 0;
    }
}
