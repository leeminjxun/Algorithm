package 백준.bruteforce.Silver.BOJ_5568_카드놓기;

import java.io.*;
import java.util.*;

public class 카드놓기 {
    static int N, K;

    static String[] cards;
    static boolean[] visited;

    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        cards = new String[N];
        visited = new boolean[N];

        for(int i = 0; i < N; i++) {
            cards[i] = br.readLine();
        }

        DFS(0, "");

        System.out.println(set.size());

    }

    static void DFS(int depth, String current) {
        if(depth == K) {
            set.add(current);
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                DFS(depth + 1, current + cards[i]);
                visited[i] = false;
            }
        }
    }

}
