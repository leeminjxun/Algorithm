package 백준.Hash.Map.Silver;

import java.io.*;
import java.util.*;

public class BOJ_10816_숫자카드2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> card = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            card.put(num, card.getOrDefault(num, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(card.containsKey(num)) {
                sb.append(card.get(num)).append(" ");
            } else {
                sb.append("0").append(" ");
            }
        }

        System.out.println(sb);
    }
}
