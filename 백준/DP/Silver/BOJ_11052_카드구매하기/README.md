# ✅ BOJ: 11052 카드 구매하기 (DP, Silver1)

https://www.acmicpc.net/problem/11052

# 풀이 과정

dp[N] -> 카드 N 개를 구매하는 경우의 수 중 최댓값을 구한다.
N 이 4 인 경우
dp[4] + P[0];
dp[3] + P[1];
dp[2] + P[2];
dp[1] + P[3];

위의 경우의 수 중 최댓값을 dp[4] 에 저장