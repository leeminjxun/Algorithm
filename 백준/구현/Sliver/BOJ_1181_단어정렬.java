package 백준.구현.Sliver;

import java.io.*;
import java.util.*;

public class BOJ_1181_단어정렬 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {

            String word = br.readLine();

            // 중복 제거 로직 -> 시간복잡도 O(N^2) 로 실행시간을 잡아먹음
//            if(list.contains(word)) {
//                continue;
//            }

            list.add(word);
        }

        Collections.sort(list, (a, b) -> {
           int lenCompare = a.length() - b.length();
           if(lenCompare != 0) return lenCompare;

           return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();
        sb.append(list.get(0) + "\n");

        for(int i = 1; i < N; i++) {
            if(!list.get(i).equals(list.get(i - 1))) {
                sb.append(list.get(i) + "\n");
            }
        }

        System.out.println(sb);
    }
}
