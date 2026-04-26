# 🔁 BOJ: 15712 번데기 (완전탐색, Sliver5)

https://www.acmicpc.net/problem/15712

# 풀이 과정

while 루프 진행과정

1. base = {번, 데기, 번, 데기} 진행
2. 반복(stage) 변수만 큼 번 과 데기를 순차적으로 반복
   - stage = 2 일 경우 for(int i = 0; i < stage; i++) "번" 반복, 이후에 "데기" 반복
