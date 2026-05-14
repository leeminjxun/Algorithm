package programmers.implementation.Lv1.가장많이받은선물;

import java.util.*;

public class 가장많이받은선물 {
    public int solution(String[] friends, String[] gifts) {
        int N = friends.length;

        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            map.put(friends[i], i);
        }

        int[][] give = new int[N][N];
        int[] giftScore = new int[N];

        for(String gift : gifts) {
            String[] arr = gift.split(" ");

            int from = map.get(arr[0]);
            int to = map.get(arr[1]);

            give[from][to]++;

            giftScore[from]++;
            giftScore[to]--;
        }

        int[] nextMonth = new int[N];

        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                if(give[i][j] > give[j][i]) nextMonth[i]++;
                else if(give[i][j] < give[j][i]) nextMonth[j]++;
                else {
                    if(giftScore[i] > giftScore[j]) nextMonth[i]++;
                    else if(giftScore[i] < giftScore[j]) nextMonth[j]++;
                }
            }
        }

        Arrays.sort(nextMonth);

        return nextMonth[N - 1];
    }
}
