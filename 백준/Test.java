package 백준;
import java.io.*;
import java.util.*;

public class Test {
    static int N;
    static int res = Integer.MAX_VALUE;

    static int[] price, target;
    static int[][] book;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] badComb = new boolean[N + 1][N + 1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            badComb[a][b] = true;
            badComb[b][a] = true;
        }

        int ans = 0;
        for(int i = 1; i <= N - 2; i++) {
            for(int j = i + 1; j <= N - 1; j++) {
                if(badComb[i][j]) continue;

                for(int k = j + 1; k <= N; k++) {
                    if(badComb[j][k] || badComb[i][j]) continue;

                    ans++;
                }
            }

        }

        System.out.println(ans);

    }
}
