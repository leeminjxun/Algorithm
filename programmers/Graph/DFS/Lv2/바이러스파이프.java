package programmers.Graph.DFS.Lv2;

import java.util.*;

// N 개의 배양체가 있고, 그 중 한개의 배양체가 바이러스에 감염된다.
// 바이러스는 파이프를 타고 이동하며, 우리는 최대한 많은 배양체에 바이러스를 감염 시켜야한다.
// 파이프의 종류는 A, B, C 가 있으며, 초기에 모든 파이프는 닫혀있다.
// 같은 종류의 파이프를 열었다 닫을 수 있고, 동시에 2개 이상의 파이프를 열었다 닫을 수 없다.

public class 바이러스파이프 {
    class Solution {
        /**
         *   n : 배양체의 개수
         *   infection : 감염된 배양체의 노드 번호
         *   edges : 파이프의 정보를 나타내는 2차원 배열
         *           edges[i] 는 [x, y, type] 의 형태로 x 번 배양체와 y 번 배양체 사이가
         type 종류의 파이프로 연결되어 있음
         *   k : 최대 행동 수
         *   return : 감염된 최대 배양체 개수
         **/
        static int answer;

        static List<int[]>[] linkedNode;

        static boolean[] infectionNode;

        public int solution(int n, int infection, int[][] edges, int k) {

            infectionNode = new boolean[n + 1];
            infectionNode[infection] = true;

            // type 배열에 따른 연결 노드 List
            linkedNode = new ArrayList[4];
            for(int i = 1; i < 4; i++) linkedNode[i] = new ArrayList<>();

            // type 1, 2, 3 에 따른 연결 노드 저장
            for(int i = 0; i < edges.length; i++) {
                int x = edges[i][0];
                int y = edges[i][1];
                int type = edges[i][2];

                linkedNode[type].add(new int[] {x, y});
            }

            answer = Integer.MIN_VALUE;

            // DFS 시도
            dfs(0, k, new int[k]);

            return answer;
        }

        static void dfs(int depth,
                        int k,
                        int[] selectedType) {
            if(depth == k) {
                boolean[] infectionResult = pipeOpen(selectedType);

                int res = 0;

                for(boolean isInfection : infectionResult) res += (isInfection == true) ? 1 : 0;

                answer = Math.max(answer, res);

                return ;
            }

            for(int i = 1; i <= 3; i++) {
                if(depth > 0 && selectedType[depth - 1] == i) continue;

                selectedType[depth] = i;
                dfs(depth + 1, k, selectedType);
            }
        }

        static boolean[] pipeOpen(int[] openPipeNumberArray) {

            boolean[] infectionResult = infectionNode.clone();

            for(int openPipeNumber : openPipeNumberArray) {

                boolean change = true;

                // 파이프가 이어진 쪽은 여러 단계를 거쳐서 모두 감염되어야 함
                while(change) {
                    change = false;

                    for(int i = 0; i < linkedNode[openPipeNumber].size(); i++) {
                        int x = linkedNode[openPipeNumber].get(i)[0];
                        int y = linkedNode[openPipeNumber].get(i)[1];

                        // 새로 감염된 노드가 없을 때 까지 반복
                        if(infectionResult[x] != infectionResult[y]) {
                            infectionResult[x] = true;
                            infectionResult[y] = true;

                            change = true;
                        }
                    }
                }
            }

            return infectionResult;
        }
    }
}
