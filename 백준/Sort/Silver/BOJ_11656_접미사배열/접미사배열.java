package 백준.Sort.Silver.BOJ_11656_접미사배열;

import java.io.*;
import java.util.*;

public class 접미사배열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> list = new ArrayList<>();

        String s = br.readLine();

        for(int i = 0; i < s.length(); i++) {
            String suffix = "";
            for(int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                suffix += c;
            }
            list.add(suffix);
        }

        Collections.sort(list);

        for(String suffix : list) {
            System.out.println(suffix);
        }
    }
}
