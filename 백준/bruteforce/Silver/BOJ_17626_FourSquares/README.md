# ❌ BOJ: 17626 Four Squares (완전탐색 / dp, Sliver3)

https://www.acmicpc.net/problem/17626

# 풀이 과정

1. N + 1 만큼의 dp 배열을 생성한다.
2. 1 ~ N 까지 반복 (index = i) 
   - 1 ~ N 까지(index j) 1 , 4, 9, 16 등 제곱 수 만큼 비교 (i 와 i - j * j) 최소값 비교