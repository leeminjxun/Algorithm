package 백준;
import java.io.*;
import java.util.*;

public class Test {
    static int N, res;
    static int[] T, P;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        T = new int[N + 1];
        P = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        res = 0;

        dfs(1, 0);

        System.out.print(res);
    }

    static void dfs(int day, int price) {
        if(day >= N + 1) {
            res = Math.max(res, price);
            return;
        }

        int endTime = day + T[day];
        if(endTime <= N + 1) {
            dfs(endTime, price + P[day]);
        }

        dfs(day + 1, price);
    }
}
