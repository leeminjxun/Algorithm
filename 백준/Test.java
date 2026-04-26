package 백준;
import java.io.*;
import java.util.*;

public class Test {
    static int n, k;

    static String[] arr;

    static boolean[] visited;

    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        arr = new String[n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        dfs(0, "");

        System.out.println(set.size());

    }

    static void dfs(int depth, String current) {
        if(depth == k) {
            set.add(current);

            return;
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, current + arr[i]);
                visited[i] = false;
            }
        }
    }
}
