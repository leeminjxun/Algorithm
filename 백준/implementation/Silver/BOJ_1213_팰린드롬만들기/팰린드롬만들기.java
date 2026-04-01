package 백준.implementation.Silver.BOJ_1213_팰린드롬만들기;

import java.io.*;

public class 팰린드롬만들기 {
    public static void main(String[] args) throws Exception {
        // 팰린드롬 : 앞으로 읽어도, 뒤로 읽어도 같은 문자, 예) 소주 만병만 주소
        // 현재 문제에서는 이를 영단어로서 표현하려한다. AABB -> ABBA (사전순으로 앞인 단어를 출력)

        // 이는 단어 개수가 짝수 일 때와 홀수 일 경우로 나뉜다.

        // 짝수 -> 4 일 경우 0, 1 인덱스와 2, 3 인덱스가 대칭을 이룬다.
            // ABBA, AABB, ABAB, BAAB, BBAA, BABA 6개
        // 홀수 -> 5 일 경우 0, 1 인덱스와 3, 4 인덱스가 대칭을 이룬다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] alpha = new int[26];

        String name = br.readLine();

        for(char ch : name.toCharArray()) {
            int a = ch - 'A';
            alpha[a]++;
        }

        int check = 0;
        int odd = 0;

        for(int a = 0; a < 26; a++) {
            if(alpha[a] % 2 != 0) {
                odd = a;
                check++;
            }
        }

        if(check > 1) {
            System.out.println("I'm Sorry Hansoo");
            return ;
        }

        StringBuilder left = new StringBuilder();
        for(int a = 0; a < 26; a++) {
            for(int i = 0; i < alpha[a] / 2; i++) {
                left.append((char)(a + 'A'));
            }
        }

        StringBuilder right = new StringBuilder(left).reverse();

        if(check == 1) {
            left.append((char)(odd + 'A'));
        }

        left.append(right);

        System.out.println(left);
    }
}

