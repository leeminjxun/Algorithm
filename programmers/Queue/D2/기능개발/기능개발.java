package programmers.Queue.D2.기능개발;

import java.util.*;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new ArrayDeque<>();

        int max = 0;

        for(int i = 0; i < progresses.length; i++) {
            int edge = (100 - progresses[i]) / speeds[i];

            if((100 - progresses[i]) % speeds[i] != 0) edge++;

            max = Math.max(max, edge);

            q.add(edge);
        }

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i <= max; i++) {
            if(!q.isEmpty() && q.peek() <= i) {
                int cnt = 0;

                while(!q.isEmpty() && q.peek() <= i) {
                    q.poll();
                    cnt++;
                }

                list.add(cnt);
            }
        }

        int[] answer = new int[list.size()];

        int idx = 0;
        for(int l : list) {
            answer[idx] = l;
            idx++;
        }

        return answer;
    }
}
