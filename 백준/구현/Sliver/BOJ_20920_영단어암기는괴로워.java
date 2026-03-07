package 백준.구현.Sliver;

import java.io.*;
import java.util.*;

public class BOJ_20920_영단어암기는괴로워 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 단어 개수
        int M = Integer.parseInt(st.nextToken()); // 외울 단어 개수

        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++) {
            String word = br.readLine();

            if(word.length() < M) continue;

            map.put(word, map.getOrDefault(word, 0) + 1); // 빈도수 를 map 에 key, value 형태로 put

        }

        List<String> list = new ArrayList<>(map.keySet());

        Collections.sort(list, (a, b) -> { // 람다식 : a 와 b 중 결과 값이 음수 : a 가 앞으로 정렬, 양수 : b 가 앞으로 정렬
            //
           int freqCompare = map.get(b) - map.get(a);
           if(freqCompare != 0) return freqCompare;

           int lenCompare = b.length() - a.length();
           if(lenCompare != 0) return lenCompare;

           return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();
        for(String word : list) {
            sb.append(word).append("\n");
        }

        System.out.println(sb);
    }
}
