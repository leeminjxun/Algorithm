package 백준;
import java.io.*;
import java.util.*;

public class Test {
    static int N, K;
    static String[] cards;
    static boolean[] visited;
    static Set<String> set;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        cards = new String[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            cards[i] = st.nextToken();
        }

        visited = new boolean[N];
        set = new HashSet<>();
        dfs(0, "");

        System.out.print(set.size());
    }

    static void dfs(int depth, String num) {
        if(set.contains(num)) return;

        if(depth == K) {
            set.add(num);
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, num + cards[i]);
                visited[i] = false;
            }
        }

    }
}
