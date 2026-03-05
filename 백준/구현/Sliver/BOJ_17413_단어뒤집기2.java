package 백준.구현.Sliver;

import java.io.*;
import java.util.*;

public class BOJ_17413_단어뒤집기2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        String str = br.readLine();

        boolean check = false;
        // < 를 만났을 경우, stack 의 내용을 전부 pop 하여 출력한다.
        // > 을 만났을 경우, > 값은 우선 출력한다. check = false

        // check = true 인 경우 -> i 인덱스에 해당하는 값을 출력한다.
        // check = false 인 경우
            // 현재 인덱스의 값이 ' '(스페이스) 인 경우 -> stack 의 값을 모두 pop, ' ' 출력
            // 인덱스의 값이 문자 인 경우 -> stack에 담는다.
        // 인덱스가 마지막 문자를 가리킬 경우 -> stack 의 모든 내용을 pop
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '<') {
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }

                check = true;
            }

            if(str.charAt(i) == '>') {
                sb.append(str.charAt(i));
                check = false;

                continue;
            }

            if(check) {
                sb.append(str.charAt(i));
            } else {
                if(str.charAt(i) == ' ') {
                    while(!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }

                    sb.append(' ');
                } else {
                    stack.push(str.charAt(i));
                }
            }

            if(i == str.length() - 1) {
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            }
        }

        System.out.println(sb);


    }
}
