# ❌ BOJ: 16508 전공책 (완전탐색 / DFS, Silver3)

https://www.acmicpc.net/problem/16508

# 풀이 과정

[경우의 수]
1. 현재 책을 고르는 수
2. 현재 책을 고르지 않는 수

문자열 비교 방법

target 문자열을 int 형 배열으로 알페벳 순으로 빈도수를 저장한다. 책의 빈도수도 마찬가지로

ABBC -> A : 1, B : 2, C : 1

이후에 current 배열과 next 배열으로 현재 책을 고르는 경우와 고르지 않는 경우를 나눈다.

만약 현재 책을 골랐다면 next 배열으 current 배열으로 복사하고,
next 배열에 현재 idx 에 해당하는 책의 알파벳 빈도수를 + 한다.

`
int[] next = current.clone();
for(int i = 0; i < 26; i++) {
    next[i] += book[idx][i];
}
`

이 후 각 알파벳에 대해 target 배열과 next 또는 current 배열을 비교하여,
target 배열의 알파벳보다 작다면 해당 경우 수의 문자열은 target 문자열을 만들 수 없다.

`
                (0, {}, 0)
              /            \
     선택(1번)              선택X
     (1, AB, 3)            (1, {}, 0)
       /      \              /      \
선택      선택X        선택      선택X
(2, AB+BC)  (2, AB)   (2, BC)   (2, {})
`