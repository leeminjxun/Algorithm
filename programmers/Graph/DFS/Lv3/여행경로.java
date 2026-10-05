package programmers.Graph.DFS.Lv3;

import java.util.*;

public class 여행경로 {
    static int N;
    static boolean[] visited;
    static String[] answer;

    public String[] solution(String[][] tickets) {
        // 티켓 + 1 만큼이 공항의 개수
        N = tickets.length + 1;

        // 방문 배열은 티켓 수 기준
        visited = new boolean[tickets.length];

        // 방문 순서를 정렬한다.
        // 출발 공항이 같을 경우 도착 공항의 알파벳이 앞서는 순으로 한다.
        Arrays.sort(tickets, (a, b) ->
                a[0].equals(b[0]) ? a[1].compareTo(b[1]) : a[0].compareTo(b[0]));

        String[] current = new String[N];
        current[0] = "ICN";

        // answer 는 null 으로 초기화 한다.
        // 갱신되었을 경우, 가지치기로 재귀 return 한다.
        answer = null;

        DFS(0, current, tickets);

        return answer;
    }

    static void DFS(int depth, String[] current, String[][] tickets) {
        if(answer != null) return;

        if(depth == N - 1) {
            answer = current.clone();
            return;
        }

        // 선택 재귀
        for(int i = 0; i < tickets.length; i++) {
            // 조건 1. 아직 방문한 적 없는 tickets 이여야한다.
            // 조건 2. depth 번째 선택된 (이전에 선택된) 항공사와 i 번째 tickets 의 출발 공항이 같은 공항이여한다.
            if(!visited[i] && current[depth].equals(tickets[i][0])) {
                visited[i] = true;
                current[depth + 1] = tickets[i][1];
                DFS(depth + 1, current, tickets);
                visited[i] = false;

                if(answer != null) return;
            }
        }
    }
}
