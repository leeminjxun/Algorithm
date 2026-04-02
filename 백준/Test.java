package 백준;
import java.io.*;
import java.util.*;

public class Test {

    // 상, 우, 하, 좌
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int testCase = 0; testCase < T; testCase++) {
            String control = br.readLine();

            int r = 0, c = 0;

            int rMin = 0, cMin = 0;

            int rMax = 0, cMax = 0;

            int dir = 0;

            for(int i = 0; i < control.length(); i++) {
                char op = control.charAt(i);

                if(op == 'F') {
                    r += dr[dir];
                    c += dc[dir];
                }

                if(op == 'B') {
                    r -= dr[dir];
                    c -= dc[dir];
                }

                if(op == 'R') {
                    dir = (dir + 1) % 4;
                    continue;
                }

                if(op == 'L') {
                    dir = (dir + 3) % 4;
                    continue;
                }

                rMin = Math.min(r, rMin);
                cMin = Math.min(c, cMin);

                rMax = Math.max(r, rMax);
                cMax = Math.max(c, cMax);
            }

            int area = (rMax - rMin) * (cMax - cMin);

            sb.append(area).append("\n");
        }

        System.out.println(sb);

    }
}
