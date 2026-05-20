package 백준.implementation.Gold.BOJ_13460_구슬탈출2;

import java.io.*;
import java.util.*;

public class 구슬탈출2 {
    static int N, M;
    static char[][] board;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class status {
        int rr, rc, br, bc, count;

        status(int rr, int rc, int br, int bc, int count) {
            this.rr = rr;
            this.rc = rc;
            this.br = br;
            this.bc = bc;

            this.count = count;
        }
    }

    static class moveResult {
        int r, c, dist;
        boolean hole;

        moveResult(int r, int c, int dist, boolean hole) {
            this.r = r;
            this.c = c;
            this.dist = dist;
            this.hole = hole;
        }

    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        int rr = 0, rc = 0, bR = 0, bC = 0;

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);

                if(board[i][j] == 'R') {
                    rr = i;
                    rc = j;
                    board[i][j] = '.';
                }
                if(board[i][j] == 'B') {
                    bR = i;
                    bC = j;
                    board[i][j] = '.';
                }
            }
        }

        System.out.println(bfs(rr, rc, bR, bC));

    }

    static int bfs(int rr, int rc, int br, int bc) {
        Queue<status> q = new ArrayDeque<>();
        boolean[][][][] visited = new boolean[N][M][N][M];

        q.add(new status(rr, rc, br, bc, 0));
        visited[rr][rc][br][bc] = true;

        while(!q.isEmpty()) {
            status cur = q.poll();

            if(cur.count > 10) continue;

            for(int d = 0; d < 4; d++) {
                moveResult red = move(rr, rc, d);
                moveResult blue = move(br, bc, d);

                if(red.hole) return cur.count + 1;

                if(blue.hole) continue;

                if(red.r == blue.r && red.c == blue.c) {
                    if(red.dist > blue.dist) {
                        red.r -= dr[d];
                        red.c -= dc[d];
                    } else if(blue.dist > red.dist) {
                        blue.r -= dr[d];
                        blue.c -= dc[d];
                    }
                }

                if(!visited[red.r][red.c][blue.r][blue.c]) {
                    visited[red.r][red.c][blue.r][blue.c] = true;
                    q.add(new status(red.r, red.c, blue.r, blue.c, cur.count + 1));
                }
            }
        }


        return -1;
    }

    static moveResult move(int r, int c, int dir) {
        int dist = 0;

        while(true) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if(board[nr][nc] == '#') break;

            r = nr;
            c = nc;
            dist++;

            if(board[r][c] == 'O') {
                return new moveResult(r, c, dist, true);
            }
        }
        
        return new moveResult(r, c, dist, false);
    }

}
