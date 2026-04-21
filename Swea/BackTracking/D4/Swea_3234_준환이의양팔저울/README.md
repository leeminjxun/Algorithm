# ❌ SWEA: 3234 준환이의 양팔 저울 (BackTracking , D4)

# 풀이과정

BackTracking 조건

1. 현재 무게 추를 오른쪽에 넣기
2. 현재 무게 추를 왼쪽에 넣기

if(right > left) return;

if(left >= total - left) (N - depth)! * 2^(N - depth) -> 시간초과 방지 중요