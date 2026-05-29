package programmers.Stack.D1.같은숫자는싫어;

import java.util.*;

public class 같은숫자는싫어 {
    public int[] solution(int[] arr) {

        Stack<Integer> stack = new Stack<>();

        for(int a : arr) {
            if(stack.isEmpty()) stack.push(a);
            else {
                if(stack.peek() != a) stack.push(a);
            }
        }

        stack.reversed();

        int[] answer = new int[stack.size()];

        for(int i = answer.length - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }
}
