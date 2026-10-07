package programmers.Graph.Floyd_Warshall;

class 순위 {
    static boolean[][] win;

    public int solution(int n, int[][] results) {
        win = new boolean[n + 1][n + 1];

        for(int[] r : results) {
            win[r[0]][r[1]] = true;
        }

        // 경유지 는 가장 바깥으로 뺀다
        for(int b = 1; b <= n; b++) {
            for(int a = 1; a <= n; a++) {
                for(int c = 1; c <= n; c++) {
                    // a win b && b win c 라면 a win c
                    if(win[a][b] && win[b][c]) win[a][c] = true;
                }
            }
        }

        int answer = 0;

        for(int i = 1; i <= n; i++) {
            int count = 0;

            for(int j = 1; j <= n; j++) {
                if(i == j) continue;

                if(win[i][j] || win[j][i]) count++;
            }

            if(count == n - 1) answer++;
        }

        return answer;
    }
}