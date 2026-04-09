# ❌ BOJ: 2195 문자열 복사 (Greedy, Gold5)

https://www.acmicpc.net/problem/2195

# 풀이 과정

P 의 각 인덱스 단위의 문자열에 대해 S 에 최대한 많이 포함되도록 골라주면 된다.

S = abc
P = aababc

위의 경우는 다음과 같이 풀이 할 수 있다.

1. 'a'ababc
'a' 는 S 에 포함된다 다음으로 넘어가자.
2. 'aa'babc
'aa' 는 S 에 포함되지 않는다. 첫번째 a 만 count 로 쳐주고, 두번째 a 부터 다시 시작하자
3. a'a'babc
마찬가지로 'a' 는 S 에 포함된다.
4. a'ab'abc
'ab' 는 S 에 포함된다
5. a'aba'bc
'aba' 는 S에 포함되지 않는다. 'ab' 만 count 로 쳐주고, 마지막 a 부터 시작
6. aab'abc'
위 와 같은 과정으로 'abc' 는 S 에 포함된다. count 로 쳐준다.

count = 3