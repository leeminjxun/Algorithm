# 🔁 BOJ: 1969 DNA (완전탐색, Sliver4)

https://www.acmicpc.net/problem/1969

# 풀이 과정

각 DNA 의 i 번 째 글자마다 {A, C, G, T} 의 빈도수를 담는 count 배열을 생성하여 풀이한다.

Hamming Distance의 최소합은 각 DNA 의 i 번째 글자의 최대 빈도수를 DNA 개수와 빼는 것이다.