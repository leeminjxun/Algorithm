package 백준.BackTracking.Gold.BOJ_15686_치킨배달;
import java.io.*;
import java.util.*;

public class 치킨배달 {


    static int N, M;

    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();

    static int[] selected;

    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());

                if(val == 1) houses.add(new int[] {i, j});
                if(val == 2) chickens.add(new int[] {i, j});
            }
        }

        // 선택된 M 개의 치킨 집 인덱스를 담는다.
        selected = new int[M];

        combination(0, 0);

        System.out.println(res);
    }

    static void combination(int start, int depth) {
        if(depth == M) {
            // M 개 선택을 모두 완료했을 경우, 이전의 최소값과 비교한다.
            res = Math.min(res, calcDistance());

            return ;
        }

        for(int i = start; i < chickens.size(); i++) {
            // 현재의 i 값(치킨집 리스트의 인덱스) 을 선택한다.
            selected[depth] = i;

            // 다음 인덱스로 재귀
            combination(i + 1, depth + 1);
        }
    }

    static int calcDistance() {
        int total = 0;

        for(int[] house : houses) {
            int minDist = Integer.MAX_VALUE;

            // 선택된 치킨집 인덱스를 순차적으로 꺼낸다.
            for(int idx : selected) {
                int[] chicken = chickens.get(idx);

                // 현재 선택된 집 과 선택된 치킨집 거리를 계산
                int dist = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);

                // 거리 최소값을 구한다.
                minDist = Math.min(minDist, dist);
            }

            // 구한 최소값을 total 값에 더한다.
            total += minDist;
        }

        // 최소값만을 더한 total return
        return total;
    }

}