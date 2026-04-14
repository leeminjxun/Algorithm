package 백준;
import java.io.*;
import java.util.*;

public class Test {
    static int N, M;

    static List<int[]> chickens = new ArrayList<>();
    static List<int[]> houses = new ArrayList<>();

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
                int info = Integer.parseInt(st.nextToken());

                if(info == 1) {
                    houses.add(new int[] {i, j});
                }

                if(info == 2) {
                    chickens.add(new int[] {i, j});
                }
            }
        }

        selected = new int[M];

        combination(0, 0);

        System.out.println(res);

    }

    static void combination(int start, int depth) {

        if(depth == M) {
            res = Math.min(res, calcDistance());

            return ;
        }

        for(int i = start; i < chickens.size(); i++) {
            selected[depth] = i;

            combination(i + 1, depth + 1);
        }
    }

    static int calcDistance() {
        int total = 0;

        for(int[] house : houses) {
            int minDist = Integer.MAX_VALUE;

            for(int idx : selected) {
                int[] chicken = chickens.get(idx);

                int dist = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);

                minDist = Math.min(minDist, dist);
            }

            total += minDist;
        }


        return total;
    }

}
