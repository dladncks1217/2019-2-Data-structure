import java.util.*;
public class main {
	public static void main(String[] args) {
		int[][] weight = {  // [그림 9-4-2](a)의 그래프
				{  0,  9, 10,  0, 0, 0, 0},
				{  9,  0,  0 ,10, 5, 0, 3}, 
				{ 10,  0,  0,  9, 7, 2, 0}, 
				{  0, 10,  9,  0, 0, 4, 8}, 
				{  0,  5,  7,  0, 0, 0, 1}, 
				{  0,  0,  2,  4, 0, 0, 6}, 
				{  0,  3,  0,  8, 1, 6, 0}, 
		};
		int N = weight.length;
		int M = 0;  // 그래프 간선의 수
		List<Edge>[] adjList = new List[N];
		for (int i = 0; i < N; i++) {
			adjList[i] = new LinkedList<>();
			for (int j = 0; j < N; j++) {
				if (weight[i][j] != 0) {
					Edge e = new Edge(i,j, weight[i][j]);
					adjList[i].add(e);
					M++;
				}
			}
		}
		KruskalMST k = new KruskalMST(adjList, M);  // KruskalMST 객체 생성
		Edge[] tree = new Edge[N-1];                // 최소신장트리의 간선을 출력하기 위해

		System.out.print("최소신장트리 간선: ");
		tree = k.mst();	   // mst() 메소드 호출

		int sum = 0;
		for (int i = 0; i < tree.length; i++) {
			System.out.print("("+tree[i].vertex + "," +tree[i].adjvertex+ ") ");
			sum += tree[i].weight;
		}
		System.out.printf("\n\n"); 
		System.out.println("최소신장트리의 간선 가중치 합 = "+sum); 
	}
}
