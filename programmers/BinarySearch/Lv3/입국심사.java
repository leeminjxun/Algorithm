package programmers.BinarySearch.Lv3;

import java.util.*;

public class 입국심사 {
    public long solution(int n, int[] times) {

        Arrays.sort(times);

        long left = 1;
        long right = (long) n * times[times.length - 1];

        long answer = right;

        while(left <= right) {
            long mid = (left + right) / 2;

            // mid 시간으로 처리 가능한 인원
            long m = 0;
            for(int i = 0; i < times.length; i++) {
                m += mid / times[i];
            }

            // 전체 인원보다 처리 가능 인원이 크거나 같은 경우 -> 시간을 줄인다.
            if(n <= m) {
                answer = Math.min(answer, mid);
                // 왼쪽 이동
                right = mid - 1;
            } else {
                // 오른쪽 이동
                left = mid + 1;
            }
        }

        return answer;
    }
}
