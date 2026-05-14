# ❌ programmers : 가장 많이 받은 선물 (구현 + 시뮬레이션 , Lv.2)

[핵심]

1. 이름 -> 인덱스
HashMap<String, Integer> map 을 통해 이름을 인덱스로서 저장하는 것이 핵심
2. 선물을 준 사람과 받은 사람 그리고 횟수
int[][] give = new int[n][n] 
2차원 배열을 통해 give[from][to] 와 같이 선물을 준 사람의 인덱스 그리고 받은 사람의 인덱스를 활용해 선물을 준 횟수를 저장
3. giftScore[from]++ / giftScore[to]--
giftScore 를 통해 선물 지수를 기록한다.
