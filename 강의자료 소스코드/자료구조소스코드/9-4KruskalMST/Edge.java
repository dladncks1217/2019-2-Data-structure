public class Edge {
	int vertex, adjvertex; // 간선의 양끝 정점들
	int weight;            // 간선의 가중치
	public Edge(int u, int v, int wt) {
		vertex    = u;
		adjvertex = v;
		weight    = wt;
	}
}
