package 백준;
import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        Stack<Character> stack = new Stack<>();

        // 1. 공백을 만났을 경우, stack 이 비워질 때 까지 꺼낸다.
        // 2. < 를 만났을 경우, 비워질 때 까지 꺼낸다.

        // reverse 변수가 true 일 경우만 위의 경우로 친다.

        // reverse 변수가 false 일 경우, < > 안에 문자이므로 뒤집지 않는다.

        // reverse 는 true 로 초기화 한다.
        boolean reverse = true;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 초기 경우의 수는 c 가 < 이거나 아닐 경우이다.
            if(c == '<') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }

                reverse = false;
            }

            if(c == '>') {
                sb.append(c);

                reverse = true;
                continue;
            }

            if(reverse) {
                if(c == ' ') {
                    while(!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }

                    sb.append(c);
                } else {
                    stack.push(c);
                }
            } else {
                sb.append(c);
            }

            if(i == s.length() - 1) {
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            }
        }

        System.out.println(sb);

    }
}
