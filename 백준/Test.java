package 백준;
import java.io.*;
import java.util.*;

public class Test {
    static int N, K, size, Max;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        size = String.valueOf(N).length();

        arr = new int[K];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Max = 0;

        dfs(0, 0);

        System.out.print(Max);
    }

    static void dfs(int depth, int current) {
        if(current > N) return;

        Max = Math.max(Max, current);

        if(depth == size) return;

        for(int i = 0; i < K; i++) {
            dfs(depth + 1, current * 10 + arr[i]);
        }
    }
}
