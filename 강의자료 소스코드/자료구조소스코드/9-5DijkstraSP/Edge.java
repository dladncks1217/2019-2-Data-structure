public class Edge {
	int vertex;     // 간선의 한쪽 끝 정점
	int adjvertex;  // 간선의 다른쪽 끝 정점
	int weight;     // 간선의 가중치

	public Edge(int u, int v, int wt) {
		vertex    = u;
		adjvertex = v;
		weight    = wt;
	}
}
