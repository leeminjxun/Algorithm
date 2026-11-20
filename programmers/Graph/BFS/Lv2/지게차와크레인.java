package programmers.Graph.BFS.Lv2;

import java.util.*;

class 지게차와크레인 {
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};

    static int N, M;

    static String[][] grid;
    static boolean[][] outContainer, visited;

    public int solution(String[] storage, String[] requests) {

        N = storage.length;
        M = storage[0].length();

        grid = new String[N][M];
        outContainer = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                grid[i][j] = String.valueOf(storage[i].charAt(j));
            }
        }

        for(String req : requests) {
            if(req.length() == 2) {
                // 크레인 사용
                C(String.valueOf(req.charAt(0)));
            } else {
                // 지게차 사용
                G(req);
            }
        }

        int answer = 0;

        for(String[] row : grid)
            for(String col : row) {
                if(!col.equals("0")) answer++;
            }

        return answer;
    }

    // 크레인 : 전체 조회 후 req 와 같은 문자라면 꺼낸다.
    static void C(String req) {
        for(int r = 0; r < N; r++)
            for(int c = 0; c < M; c++) {
                if(grid[r][c].equals(req)) {
                    grid[r][c] = "0";
                    outContainer[r][c] = true;
                }
            }
    }

    // 지게차 : 4방 탐색을 통해 grid 범위 밖에 나가거나 0이면 컨테이너를 꺼내 "0" 으로 만든다.
    static void G(String req) {

        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                if(grid[r][c].equals(req)) {
                    // BFS 로 돌려 범위 밖으로 나가는 경로가 있는지 탐색한다.
                    if(BFS(r, c)) grid[r][c] = "0";
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(grid[i][j].equals("0") && !outContainer[i][j]) outContainer[i][j] = true;
            }
        }
    }

    // 4방 탐색을 통해 범위 밖으로 나가는 컨테이너 이거나 0 인 경로를 따라 범위 밖으로 나가는 길이 있는지 탐색한다.
    // 경로 탐색 시에는 grid 값 뿐만 아니라 visited 배열까지 함께 보며 이번 턴에 빠진 컨테이너는 제거한다.
    static boolean BFS(int r, int c) {
        visited = new boolean[N][M];

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {r, c});

        visited[r][c] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cr = cur[0];
            int cc = cur[1];

            // 4방 탐색
            for(int dir = 0; dir < 4; dir++) {
                int nr = cr + dr[dir];
                int nc = cc + dc[dir];

                // 범위 밖이여서 컨테이너를 꺼낼 수 있는 경우
                if(nr < 0 || nr >= N || nc < 0 || nc >= M) {
                    return true;
                }

                // grid 가 0 이며, 이전 시도에서 컨테이너가 빠져있고 방문하지 않은 경로
                if(grid[nr][nc].equals("0") && outContainer[nr][nc] && !visited[nr][nc]) {
                    queue.add(new int[] {nr, nc});

                    visited[nr][nc] = true;
                }
            }
        }

        return false;
    }
}