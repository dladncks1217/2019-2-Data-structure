01 import java.util.*;
02 public class TopologicalSort {
03     int N;                        // 그래프의 정점 수
04     boolean[] visited;            // DFS 수행 중 방문여부 체크 용
05     List<Integer>[] adjList;      // 인접리스트 형태의 입력 그래프
06     List<Integer> sequence;       // 위상 정렬 순서를 담을 리스트
07     public TopologicalSort(List<Integer>[] graph) {  //생성자
08         N = graph.length;
09         visited = new boolean[N]; 
10         adjList = graph;
11         sequence = new ArrayList<>();
12     }
13     public List<Integer> tsort() {     // 위상정렬을 위한 DFS 수행
14         for (int i = 0; i < N; i++)    if (!visited[i]) dfs(i);
15         Collections.reverse(sequence); // sequence를 역순으로 만들기
16         return sequence;
17     }
18     public void dfs(int i) {       // DFS 수행
19         visited[i] = true;
20         for (int v : adjList[i]) { // u의 방문이 끝나고 앞으로 방문해야하는 각 정점 v에 대해
21             if (!visited[v]) dfs(v);
22         }
23         sequence.add(i);           // u에서 진출하는 간선이 더 이상 없으므로 u를 sequence에 추가 
24     }
25 }