# ✅ BOJ: 2096 내려가기 (DP , Gold5)

https://www.acmicpc.net/problem/2096

# 풀이 과정

점화식 (최댓값)

if(j - 1 >= 0) {
    dp[i + 1][j - 1] = Math.max(dp[i + 1][j - 1], arr[i + 1][j - 1] + dp[i][j]);
}

dp[i + 1][j] = Math.max(dp[i + 1][j], arr[i + 1][j] + dp[i][j]);

if(j + 1 < 3) {
    dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], arr[i + 1][j + 1] + dp[i][j]);
}