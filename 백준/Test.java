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

        String s = br.readLine();
        target = new int[26];
        for(int i = 0; i < s.length(); i++) {
            target[s.charAt(i) - 'A']++;
        }

        N = Integer.parseInt(br.readLine());

        price = new int[N];
        book = new int[N][26];

        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            price[i] = Integer.parseInt(st.nextToken());
            String b = st.nextToken();

            for(int j = 0; j < b.length(); j++) {
                book[i][b.charAt(j) - 'A']++;
            }
        }

        dfs(0, 0, new int[26]);

        System.out.println(res == Integer.MAX_VALUE ? -1 : res);

    }

    static void dfs(int depth, int totalPrice, int[] current) {
        if(totalPrice > res) return ;

        if(check(current)) {
            res = Math.min(res, totalPrice);
            return;
        }

        if(depth == N) return ;

        int[] next = current.clone();
        for(int i = 0; i < 26; i++) {
            next[i] += book[depth][i];
        }

        dfs(depth + 1, totalPrice + price[depth], next);
        dfs(depth + 1, totalPrice, current);
    }

    static boolean check(int[] current) {
        for(int i = 0; i < 26; i++) {
            if(current[i] < target[i]) {
                return false;
            }
        }

        return true;
    }
}
