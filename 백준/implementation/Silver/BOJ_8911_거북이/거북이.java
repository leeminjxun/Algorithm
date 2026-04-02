package 백준.implementation.Silver.BOJ_8911_거북이;

import java.io.*;

public class 거북이 {
    // 방향 : 북 -> 동 -> 남 -> 서
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int testCase = 0; testCase < T; testCase++) {
            String S = br.readLine();

            // 현재 x,y 값
            int x = 0, y = 0;

            // 거북이가 지나간 최소, 최대 x, y 값 저장
            int maxX = 0;
            int maxY = 0;
            int minX = 0;
            int minY = 0;

            // 방향은 북 쪽으로 시작
            int dir = 0;

            for(int i = 0; i < S.length(); i++) {
                char c = S.charAt(i);

                if(c == 'F') {
                    x += dx[dir];
                    y += dy[dir];
                }

                if(c =='B') {
                    x -= dx[dir];
                    y -= dy[dir];
                }
                // 왼쪽으로 90도 회전
                if(c == 'L') {
                    dir = (dir + 3) % 4;
                }
                // 오른쪽으로 90도 회전
                if(c == 'R') {
                    dir = (dir + 1) % 4;
                }

                minX = Math.min(x, minX);
                minY = Math.min(y, minY);

                maxX = Math.max(x, maxX);
                maxY = Math.max(y, maxY);
            }

            int area = (maxX - minX) * (maxY - minY);
            System.out.println(area);

        }
    }
}
