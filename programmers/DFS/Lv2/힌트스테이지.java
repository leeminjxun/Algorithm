package programmers.DFS.Lv2;

class 힌트스테이지 {
    static int minCost, hintLength, costLength;

    public int solution(int[][] cost, int[][] hint) {

        costLength = cost.length;
        hintLength = hint.length;

        int[] hintCount = new int[costLength];

        minCost = Integer.MAX_VALUE;

        dfs(0, 0, hintCount, cost, hint);

        return minCost;
    }

    // 재귀 : 현재 스테이지에 힌트 번들을 선택하는가, 하지 않는가
    static void dfs(int depth, int currentCost, int[] hintCount, int[][] cost, int[][] hint) {

        if(depth == hintLength) {

            int totalCost = currentCost;

            for(int i = 0; i < costLength; i++) {
                totalCost += cost[i][hintCount[i]];
            }

            minCost = Math.min(minCost, totalCost);

            return;
        }

        // depth 번째 스테이지에서 번들을 선택하지 않음
        dfs(depth + 1, currentCost, hintCount, cost, hint);

        // depth 번째 스테이지에서 번들을 선택함
        int[] tempCount = hintCount.clone();

        for(int i = 1; i < hint[depth].length; i++) {
            int hintNumber = hint[depth][i] - 1;

            if(tempCount[hintNumber] + 1 >= costLength) continue;

            tempCount[hintNumber]++;
        }

        dfs(depth + 1, currentCost + hint[depth][0], tempCount, cost, hint);

    }
}