package 백준.Stack.Silver.BOJ_9012_괄호;

import java.io.*;
import java.util.*;

public class 괄호 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        int T = Integer.parseInt(br.readLine());

        for(int testCase = 0; testCase < T; testCase++) {
            String S = br.readLine();

            stack.clear();

            for(int i = 0; i < S.length(); i++) {
                char c = S.charAt(i);

                if(c == '(') {
                    stack.push(c);
                }

                if(c == ')') {
                    if(stack.isEmpty()) {
                        stack.push(c);
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if(stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
