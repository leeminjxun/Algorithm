package 백준.implementation.Bronze.BOJ_1157_단어공부;

import java.io.*;

public class 단어공부 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int[] arr = new int[26];

        for(int i = 0; i < s.length(); i++) {
            int alpha = s.charAt(i);

            if(65 <= alpha && alpha <= 90) { // 대문자 일 경우
                arr[alpha - 65]++;
            } else { // 소문자 인 경우
                arr[alpha - 97]++;
            }
        }

        int max = 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) max = arr[i];
        }

        int maxCount = 0;
        int maxIndex = 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == max) {
               maxIndex = i;
               maxCount++;
            }
        }

        if(maxCount == 1) {
            int ascii = 65 + maxIndex;
            System.out.println((char) ascii);
        } else {
            System.out.println('?');
        }

    }

}
