package programmers.Graph.DFS.Lv2;

import java.util.*;

public class 리프노드수최대화 {
    public long solution(int dist_limit, long split_limit) {
        // 루트의 유일한 자식 1개(깊이 1, 누적 곱 1)에서 탐색 시작
        return dfs(1, 1, dist_limit, split_limit);
    }

    /**
     * cur : 현재 깊이에 있는 Node 수 (리프 노드의 후보)
     * prod : 루트부터 현재까지의 자식 노드 수의 곱 (현재 분배도)
     * dist : 남은 분배 노드 수
     * limit : 분배도 상한
     **/
    private long dfs(long cur, long prod, int dist, long limit) {
        // max 를 우선적으로 현재 깊이 에 있는 Node 수로 지정한다.
        // 현재 깊에 있는 Node 가 분배 node 로 선정되지 않았을 경우 리프 node 가 된다.
        // max 는 최대 리프 노드의 개수를 나타낸다.
        long max = cur;

        // 3을 먼저 분기 할 때, 리프 노드가 2 씩 늘어난다.
        for (int b : new int[]{3, 2}) {
            // prod * b <= limit 와 같다.
            // 현재 node 에서 3으로 분기 했을 때, 분배도 상한과 비교한다.
            if (prod <= limit / b) {

                // use 는 분배노드가 될 수 있는 최대 노드 개수이다.
                // cur 과 dist 중 더 작은 값을 고른다.
                long use = Math.min(cur, (long) dist);

                if (use > 0) {
                    // 현재 레벨 리프(cur - use) + 다음 레벨 재귀 탐색 리프
                    long next = (cur - use)
                            + dfs(use * b, prod * b, dist - (int) use, limit);
                    max = Math.max(max, next);
                }
            }
        }

        return max;
    }
}
