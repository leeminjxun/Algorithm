package programmers.Graph.BFS.Lv3;

import java.util.*;

public class 아이템줍기 {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        int maxX = 0;
        int maxY = 0;

        for(int[] r : rectangle) {
            maxX = Math.max(maxX, r[2]) * 2;
            maxY = Math.max(maxY, r[3]) * 2;
        }

        boolean[][] border = new boolean[maxX + 1][maxY + 1];
        boolean[][] visited = new boolean[maxX + 1][maxY + 1];

        for(int[] r : rectangle) {
            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;

            for(int x = x1; x <= x2; x++) {
                for(int y = y1; y <= y2; y++) {
                    border[x][y] = true;
                }
            }
        }

        for(int[] r : rectangle) {
            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;

            for(int x = x1 + 1; x < x2; x++) {
                for(int y = y1 + 1; y < y2; y++) {
                    border[x][y] = false;
                }
            }
        }

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {characterX * 2, characterY * 2, 0});

        visited[characterX * 2][characterY * 2] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            int cx = cur[0];
            int cy = cur[1];
            int dist = cur[2];

            if(cx == itemX * 2 && cy == itemY * 2) return dist / 2;

            for(int dir = 0; dir < 4; dir++) {
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];

                if(nx < 0 || ny < 0 || nx >= maxX + 1 || ny >= maxY + 1) continue;
                if(!border[nx][ny] || visited[nx][ny]) continue;

                q.offer(new int[] {nx, ny, dist + 1});
                visited[nx][ny] = true;
            }

        }

        return 0;
    }
}
