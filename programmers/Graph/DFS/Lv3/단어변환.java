package programmers.Graph.DFS.Lv3;

import java.util.*;

class 단어변환 {
    static boolean[] visited;
    static int res, N;

    public int solution(String begin, String target, String[] words) {
        N = words.length;

        res = Integer.MAX_VALUE;

        visited = new boolean[N];

        DFS(begin, target, 0, words);

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    static void DFS(String current, String target, int cnt, String[] words) {
        if(cnt >= res) return;

        if(current.equals(target)) {
            res = Math.min(res, cnt);

            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i] && compare(current, words[i])) {
                visited[i] = true;
                DFS(words[i], target, cnt + 1, words);
                visited[i] = false;
            }
        }
    }

    static boolean compare(String a, String b) {

        int cnt = 0;

        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) cnt++;

            if(cnt > 1) return false;
        }

        return true;
    }
}
