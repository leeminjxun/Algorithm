# 🔁 SWEA: 1486 장훈이의 높은 선반 (BackTracking , D4)

# 풀이과정

BackTracking 조건

1. sum 이 minH 보다 크거나 같다면 return
2. sum 이 B 보다 크거나 같다면 minH 와 비교하여 최솟값을 minH 에 저장
3. idx 가 N 과 같은 경우 return

dfs(현재 직원을 선택하는 경우)
dfs(현재 직원을 선택하지 않는 경우)