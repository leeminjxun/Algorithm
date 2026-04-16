package 백준;
import java.io.*;
import java.util.*;

public class Test {
    static int N;
    static int maxPrice;

    static int[] T, P;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        T = new int[N + 1];
        P = new int[N + 1];

        maxPrice = 0;

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, 0);

        System.out.println(maxPrice);
    }

    static void dfs(int depth, int sum) {
        if(depth >= N + 1) {
            maxPrice = Math.max(maxPrice, sum);
            return ;
        }

        if(depth + T[depth] <= N + 1) {
            dfs(depth + T[depth], sum + P[depth]);
        }

        dfs(depth + 1, sum);
    }
}
