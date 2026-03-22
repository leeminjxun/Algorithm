package 백준.Sort.Silver;

import java.io.*;
import java.util.*;

public class BOJ_1431_시리얼번호 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        Collections.sort(list, (a, b) -> {
            int lenCompare = a.length() - b.length();
            if(lenCompare != 0) return lenCompare;

            int aSum = 0;
            int bSum = 0;

            for(int i = 0; i < a.length(); i++) {
                char c = a.charAt(i);
                if('0' <= c && c <= '9') aSum += c - '0';
            }
            for(int i = 0; i < b.length(); i++) {
                char c = b.charAt(i);
                if('0' <= c && c <= '9') bSum += c - '0';
            }

            int sumCompare = aSum - bSum;
            if(sumCompare != 0) return sumCompare;

            return a.compareTo(b);

        });

        for(String word : list) {
            System.out.println(word);
        }
    }
}
