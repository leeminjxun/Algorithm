package 백준.Stack.Silver.BOJ_10828_스택;

import java.io.*;
import java.util.*;

public class 스택 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Stack<Integer> stack = new Stack<>();

        int T = Integer.parseInt(br.readLine());

        for(int testCase = 0; testCase < T; testCase++) {
            st = new StringTokenizer(br.readLine());

            String op = st.nextToken();
            int num = 0;

            if(op.equals("push")) {
                num = Integer.parseInt(st.nextToken());
                stack.push(num);
            }

            if(op.equals("pop")) {
                if(!stack.isEmpty()) System.out.println(stack.pop());
                else System.out.println("-1");
            }

            if(op.equals("size")) {
                System.out.println(stack.size());
            }

            if(op.equals("empty")) {
                if(!stack.isEmpty()) System.out.println("0");
                else System.out.println("1");
            }

            if(op.equals("top")) {
                if(!stack.isEmpty()) System.out.println(stack.peek());
                else System.out.println("-1");
            }
        }


    }
}
