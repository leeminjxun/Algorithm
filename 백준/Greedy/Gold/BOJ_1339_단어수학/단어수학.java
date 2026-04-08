package 백준.Greedy.Gold.BOJ_1339_단어수학;

import java.io.*;
import java.util.*;

public class 단어수학 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 알파벳 가중치 계산 배열
        int[] alphaWeight = new int[26];

        for(int i = 0; i < N; i++) {
            String word = br.readLine();

            // 가장 앞 단의 수를 기준으로 해당 단어의 최대 가중치 계산
            int base = (int) Math.pow(10, word.length() - 1);

            // 같은 단어가 나올 수 있기에 가중치는 누적된다.
            for(int j = 0; j < word.length(); j++) {
                alphaWeight[word.charAt(j) - 'A'] += base;

                // 가중치는 뒤로 갈수록 10의 단위 씩 줄어든다
                base /= 10;
            }
        }

        // 가장 큰 수 먼저 숫자를 부여하기 위해 정렬 진행, 알파벳 인덱스는 중요하지 않다
        Arrays.sort(alphaWeight);

        int totalSum = 0;
        int number = 9;

        for(int i = 25; i >= 0; i--) {
            if(alphaWeight[i] == 0) break;

            totalSum += number * alphaWeight[i];
            number--;
        }

        System.out.println(totalSum);


    }
}
