package programmers.implementation.Lv1.신고결과받기;

import java.util.*;

public class 신고결과받기 {
    static int[] solution(String[] id_list, String[] reports, int k) {
        int n = id_list.length;

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            map.put(id_list[i], i);
        }

        boolean[][] accuse = new boolean[n][n];
        int[] susPension = new int[n];

        for(String report : reports) {
            String[] arr = report.split(" ");

            int from = map.get(arr[0]);
            int to = map.get(arr[1]);

            if(!accuse[from][to]) {
                accuse[from][to] = true;
                susPension[to]++;
            }
        }

        int[] mails = new int[n];

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(accuse[i][j] && susPension[j] >= k) mails[i]++;

                if(accuse[j][i] && susPension[i] >= k) mails[j]++;
            }
        }

        return mails;
    }
}
