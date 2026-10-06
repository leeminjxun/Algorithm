package programmers.Graph.BFS.Lv3;

import java.util.*;

public class 퍼즐조각채우기 {

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};

    static int N;

    static List<List<int[]>> blanks, pieces;

    // BFS 방문 배열
    static boolean[][] visited;

    // 조각 사용 배열
    static boolean[] usedPieces;

    public int solution(int[][] board, int[][] table) {
        N = board.length;

        // board 의 빈칸, table 의 퍼즐 좌표를 blanks 와 pieces 에 입력 (BFS)
        blanks = new ArrayList<>(); pieces = new ArrayList<>();

        visited = new boolean[N][N];

        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                if(!visited[r][c] && board[r][c] == 0) {
                    // 빈칸은 0 을 따라간다.
                    blanks.add(BFS(r, c, board, 0));
                }
            }
        }

        visited = new boolean[N][N];

        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                if(!visited[r][c] && table[r][c] == 1) {
                    // 조각은 1 을 따라간다.
                    pieces.add(BFS(r, c, table, 1));
                }
            }
        }

        int answer = 0;

        usedPieces = new boolean[pieces.size()];

        for(List<int[]> blank : blanks) {
            for(int i = 0; i < pieces.size(); i++) {
                if(usedPieces[i]) continue;

                boolean isOk = false;
                List<int[]> piece = pieces.get(i);

                for(int rotate = 0; rotate < 4; rotate++) {
                    if(isSame(blank, piece)) {
                        isOk = true;
                        break;
                    }

                    // 회전, rotate 만큼
                    piece = rotation(piece);
                }

                if(isOk) {
                    usedPieces[i] = true;
                    answer += blank.size();
                    // 다음 blank 로 이동
                    break;
                }
            }
        }

        return answer;
    }

    // List<int[]> 좌표 그룹을 반환하는 BFS, target 에 따른 탐색
    static List<int[]> BFS(int r, int c, int[][] grid, int target) {
        List<int[]> group = new ArrayList<>();
        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[] {r, c});
        visited[r][c] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            int cr = cur[0], cc = cur[1];
            group.add(new int[] {cr, cc});

            for(int dir = 0; dir < 4; dir++) {
                int nr = cr + dr[dir];
                int nc = cc + dc[dir];

                if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if(visited[nr][nc] || grid[nr][nc] != target) continue;

                q.add(new int[] {nr, nc});
                visited[nr][nc] = true;
            }
        }

        return nomalization(group);
    }

    // 흩어져있는 좌표를 0, 0 기준으로 절대좌표로 정규화 후 정렬
    static List<int[]> nomalization(List<int[]> cells) {
        int minR = Integer.MAX_VALUE, minC = Integer.MAX_VALUE;
        for(int[] c : cells) { minR = Math.min(minR, c[0]); minC = Math.min(minC, c[1]); }
        List<int[]> res = new ArrayList<>();
        for(int[] c : cells) res.add(new int[] {c[0] - minR, c[1] - minC});

        res.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        return res;
    }

    // 좌표 회전 메서드, (r, c) -> (c, -r) 가 90도 회전 로직.
    // 좌표 변환 음수 발생 -> nomalization 으로 정규화
    static List<int[]> rotation(List<int[]> cells) {
        List<int[]> res = new ArrayList<>();
        for(int[] c : cells) res.add(new int[] {c[1], c[0] * -1});

        return nomalization(res);
    }

    static boolean isSame(List<int[]> a, List<int[]> b) {
        if(a.size() != b.size()) return false;

        for(int i = 0; i < a.size(); i++) {
            if(a.get(i)[0] != b.get(i)[0] || a.get(i)[1] != b.get(i)[1]) return false;
        }

        return true;
    }
}
