package 백준.implementation.Silver.BOJ_17413_단어뒤집기2;

import java.io.*;
import java.util.*;

public class 단어뒤집기2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        String s = br.readLine();

        boolean reverse = true;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c == '<') {
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }

                reverse = false;
                sb.append(c);

                continue;
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
