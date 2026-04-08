# ❌ BOJ: 1715 카드 정렬하기(DP, Gold4)

https://www.acmicpc.net/problem/1715

# 풀이 과정

N = 5
10, 20, 40, 50, 60

1. priority queue : 10, 20, 40, 50, 60
currentSum : 10 + 20 = 30, totalSum : 30

2. priority queue : 30, 40, 50, 60
currentSum : 30 + 40 = 70, totalSum : 30 + 70

3. priority queue : 50, 60, 70
currentSum : 50 + 60 = 110, totalSum : 30 + 70 + 110

4. priority queue : 70 110
currentSum : 70 + 110 = 180, totalSum : 30 + 70 + 110 + 180

5. priority queue : 180 -> break;




