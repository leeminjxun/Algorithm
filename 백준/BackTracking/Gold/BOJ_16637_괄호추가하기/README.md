# ❌ BOJ: 16637 괄호 추가하기 (백트레킹 / 문자열 처리, Gold3)

https://www.acmicpc.net/problem/16637

# 풀이 과정

[핵심]

괄호를 칠지 말지 선택하면서 가능한 모든 계산 결과를 탐색한다.

1. 괄호를 치지 않는 경우 -> 현재 수식 묶음만 계산
ex) 1+2*3-4

index 0 에서 시작

current = index(0) = 1
op = index + 1 = +
nextNum = index + 2 = 2

dfs(idx + 2, calculator(current, op, nextNum))

2. 괄호를 치는 경우 -> 다음 수식 묶음에 괄호를 쳐 계산하고, 해당 결과를 현재 수식 묶음과 계산

idx 0 에서 시작

current = idx(0) = 1
currentOp = idx + 1 = +
nextNum = idx + 2 = 2

nextOp = idx + 3 = *
nextNextNum = idx + 4 = 3

nextResult = calculator(nextNum, nextOp, nextNextNum)

dfs(idx + 4, calculator(current, op, nextResult))

