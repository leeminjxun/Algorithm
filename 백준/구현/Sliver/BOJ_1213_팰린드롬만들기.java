package 백준.구현.Sliver;

import java.io.*;
import java.util.*;

public class BOJ_1213_팰린드롬만들기 {
    public static void main(String[] args) throws Exception {
        // 팰린드롬 : 앞으로 읽어도, 뒤로 읽어도 같은 문자, 예) 소주 만병만 주소
        // 현재 문제에서는 이를 영단어로서 표현하려한다. AABB -> ABBA (사전순으로 앞인 단어를 출력)

        // 이는 단어 개수가 짝수 일 때와 홀수 일 경우로 나뉜다.

        // 짝수 -> 4 일 경우 0, 1 인덱스와 2, 3 인덱스가 대칭을 이룬다.
            // ABBA, AABB, ABAB, BAAB, BBAA, BABA 6개
        // 홀수 -> 5 일 경우 0, 1 인덱스와 3, 4 인덱스가 대칭을 이룬다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String name = br.readLine();

        int[] count = new int[26];

        for(int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);

            count[c - 'A']++;
        }

        int odd = 0;
        char mid = 0;

        for(int i = 0; i < 26; i++) {
            if(count[i] % 2 == 1) {
                odd++;
                mid = (char)(i + 'A');
            }
        }

        if(odd > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder left = new StringBuilder();

        for(int i = 0; i < 26; i++) {
            for(int j = 0; j < count[i]/2; j++) {
                left.append((char)(i + 'A'));
            }
        }

        // left 값과 대칭으로 생성된 right
        StringBuilder right = new StringBuilder(left).reverse();

        if(odd == 1) {
            left.append(mid);
        }

        left.append(right);

        System.out.println(left);
    }
}
