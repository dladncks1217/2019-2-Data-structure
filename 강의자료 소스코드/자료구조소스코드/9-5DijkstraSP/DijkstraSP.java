import java.util.List;
public class DijkstraSP{   
	public int N;           // 그래프 정점의 수
	List<Edge>[] graph;
	public int[] previous;  // 최단경로상 이전 정점을 기록하기 위해
	public DijkstraSP(List<Edge>[] adjList) {
		N = adjList.length;
		previous = new int[N];
		graph = adjList;
	} 
	public int[] shortestPath (int s){
		boolean[] visited = new boolean[N];
		int[] D = new int[N];                 
		for(int i = 0; i < N; i++){   //초기화
			visited[i] = false;
			previous[i] = -1;
			D[i] = Integer.MAX_VALUE;
		}
		previous[s] = 0;  // 시작점 s의 관련 정보 초기화
        D[s]= 0;       
		for(int k = 0; k < N; k++){        // 방문 안된 정점들 중에서
			int minVertex = -1;            // D원소 값이 최소인 minVertex 찾기
			int min = Integer.MAX_VALUE;
			for(int j = 0; j < N; j++){
				if ((!visited[j]) && (D[j] < min)){
					min = D[j];
					minVertex = j;
				}
			}
			visited[minVertex] = true;
			for (Edge e: graph[minVertex]){  // minVertex에 인접한 각 정점에 대해
				if (!visited[e.adjvertex]){  // 아직  방문 안된 정점에 대해
					int currentDist = D[e.adjvertex];
					int newDist = D[minVertex] + e.weight;
					if (newDist < currentDist){		    		
						D[e.adjvertex] = newDist;           // 간선완화
						previous[e.adjvertex] = minVertex;  // 최종 최단경로를 '역 방향으로'추출
					}
				}
			}
		}   
		return D;
	}
}

