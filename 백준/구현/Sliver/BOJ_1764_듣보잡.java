package 백준.구현.Sliver;

import java.io.*;
import java.util.*;

public class BOJ_1764_듣보잡 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 듣도 못한 사람의 수
        int N = Integer.parseInt(st.nextToken());
        // 보도 못한 사람의 수
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> unheard = new HashSet<>();
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            unheard.add(s);
        }

        LinkedList<String> result = new LinkedList<>();
        for(int i = 0; i < M; i++) {
            String s = br.readLine();
            if(unheard.contains(s)) {
                result.add(s);
            }
        }

        Collections.sort(result);

        System.out.println(result.size());
        for(String s : result) {
            System.out.println(s);
        }
    }
}
