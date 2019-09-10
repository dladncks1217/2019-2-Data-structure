import java.util.List;
public class DFS {
	int N;	 // 그래프 정점의 수
	List<Edge>[] graph;
	private boolean[ ] visited;	// DFS 수행 중 방문한 정점을 true로 만든다.
	public DFS(List<Edge>[] adjList) { // 생성자
		N = adjList.length;
		graph = adjList;
		visited = new boolean [N];
		for (int i = 0; i < N; i++) visited[i] = false;  // 배열 초기화
		for (int i = 0; i < N; i++) if (!visited[i]) dfs(i);
	}
	private void dfs(int i) {
		visited[i] = true;        // 점점 i가 방문되어 visited[i]를 true로 만든다.
		System.out.print(i+" ");  // 정점 i가 방문되었음을 출력한다.
		for (Edge e: graph[i]) {  // 정점 i에 인접한 각 정점에 대해
			if (!visited[e.adjvertex]) { // 정점 i에 인접한 정점이 방문 안되었으면 재귀호출
				dfs(e.adjvertex);
			}
		}
	}
}
