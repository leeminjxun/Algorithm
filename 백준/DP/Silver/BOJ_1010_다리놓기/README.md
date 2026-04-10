# 🔁 BOJ: 1010 다리놓기 (DP / 수학, Silver5)

https://www.acmicpc.net/problem/1010

# 풀이과정

파스칼의 삼각형 원리를 이용한다.

nCr = n-1Cr-1 + n-1Cr

해당 원리를 백트레킹 하여 계산한다.

n-1Cr-1 = n-2Cr-2 + "n-2Cr-1"

n-1Cr = "n-2Cr-1" + n-2Cr

허나 일반적인 백트레킹의 경우 같은 값을 또 다시 계산 해야할 경우가 있다.
위의 n-2Cr-1 이 그러한 경우이다.

해서 우리는 이러한 중복을 줄이고자 DP 개념을 또다시 도입한다.

if(dp[n][r] > 0) {
    return dp[n][r];
}