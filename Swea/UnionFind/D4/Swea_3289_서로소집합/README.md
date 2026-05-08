# ❌ SWEA: 3289 서로소 집합 (union-find , D3)

# 풀이과정

parent 1차원 배열을 생성하여 각 index 값과 배열값을 일치시켜준다.

parent[1] = 1;
parent[2] = 2;
parent[3] = 3;
...

[find(int x)]

- x 는 찾고자하는 집합이다.

if parent[x] = x :
x 가 해당 집합의 대표 root 이다.

if parent[x + 1] = x :
x + 1의 부모(상위 노드)가 x 이다.
(x + 1) -> x

find 함수에서는 parent[x] != x 일 경우 해당 인덱스의 최상위 노드를 찾기위해 재귀적 탐색을 진행한다.

`return parent[x] = find(parent[x]);`

[union(int a, int b)]

- a 와 b 는 union 을 진행하는 대상이다.

find(a), find(b) 를 진행해 각 노드가 가리키는 최상위 노드가 같지 않다면, a와 b가 속한 두 집합을 하나로 합친다.

`parent[find(a)] = find(b);`


