package 백준.구현.Sliver;

import java.io.*;
import java.util.*;


public class BOJ_20291_파일정리 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        String name = "";
        String extension = "";

        // 확장자 빈도수 HashMap 저장
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), ".");

            name = st.nextToken();
            extension = st.nextToken();

            map.put(extension, map.getOrDefault(extension, 0) + 1);

        }

        List<String> list = new ArrayList<>(map.keySet());

        Collections.sort(list);

        for(String word : list) {
            System.out.print(word + " ");
            System.out.println(map.get(word));
        }

    }
}
