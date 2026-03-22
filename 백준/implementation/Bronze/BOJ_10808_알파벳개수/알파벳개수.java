package 백준.implementation.Bronze.BOJ_10808_알파벳개수;

import java.io.*;

public class 알파벳개수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        int[] arr = new int[26];

        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            int num = (int)(c - 'a');

            arr[num]++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
    }
}
