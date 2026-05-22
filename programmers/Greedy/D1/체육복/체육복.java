package programmers.Greedy.D1.체육복;

import java.util.*;

public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] student = new int[n];

        Arrays.fill(student, 1);

        for(int i = 0; i < lost.length; i++) {
            student[lost[i] - 1]--;
        }

        for(int i = 0; i < reserve.length; i++) {
            student[reserve[i] - 1]++;
        }

        for(int i = 0; i < n; i++) {
            if(student[i] == 0) {
                if(i - 1 >= 0 && student[i - 1] == 2) {
                    student[i - 1]--;
                    student[i]++;
                    continue;
                }

                if(i + 1 < n && student[i + 1] == 2) {
                    student[i + 1]--;
                    student[i]++;
                    continue;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            if(student[i] > 0) {
                answer++;
            }
        }

        return answer;
    }
}
