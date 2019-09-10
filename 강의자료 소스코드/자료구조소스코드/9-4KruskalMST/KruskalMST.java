import java.util.*;
public class KruskalMST {
	int N, M; // 그래프 정점, 간선의 수
	List<Edge>[] graph;
	UnionFind uf; // Union-Find 연산을 사용하기 위해	
	Edge[] tree;	
	static class Weight_Comparison implements Comparator<Edge> { //weight를 기준으로 우선순위큐를  사용하기 위해
		public int compare(Edge e, Edge f) {
			if(e.weight > f.weight)
				return 1;
			else if(e.weight < f.weight)
				return -1;		
			return 0;
		}		
	}
	public KruskalMST(List<Edge>[] adjList, int numOfEdges) {
		N = adjList.length;
		M = numOfEdges;
		graph = adjList;
		uf = new UnionFind(N);	// Union-Find 연산을 사용하기 위해	
		tree = new Edge[N-1];
	}
	public Edge[] mst()	{  // Kruskal 알고리즘		
		Weight_Comparison BY_WEIGHT = new Weight_Comparison();  // 우선순위큐를  weight 기준으로 구성하기 위해		
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>(M, BY_WEIGHT);  // 자바 라이브러리의 우선순위큐 사용
								    // 우선순위큐의 크기로 M(간선의 수)을 지정, BY_WEIGHT는 line 24의 comparator
		for (int i = 0; i < N; i++){ 
			for (Edge e : graph[i]){
				pq.add(e);  // edgeArray의 간선 객체들을 pq에 삽입
			}
		}		
		int count = 0;	
		while (!pq.isEmpty() && count < N-1) {
			Edge e = pq.poll();          // 최소 가중치를 가진 간선를 pq에서 제거하고 가져옴
			int u = e.vertex;            // 가져온 간선의 한 쪽 정점
			int v = e.adjvertex; 	     // 가져온 간선의 다른 한 쪽 정점
			if (!uf.isConnected(u, v)) { // v와 w가 각각 다른 집합에 속해 있으면
				uf.union(u, v);          // v가 속한 집합과 u가 속한 집합의 합집합 수행
				tree[count++] = e;       // e를 MST의 간선으로서 tree에 추가
			}
		}			
		return tree;
	}
}
 