import java.util.*;
public class main {
	public static void main(String[] args) {
		int[][] weight = { // [그림 9-4-2](a)의 그래프
				{ 0, 9, 10, 0, 0, 0, 0},
				{ 9, 0, 0 ,10, 5, 0, 3}, 
				{ 10, 0, 0, 9, 7, 2, 0}, 
				{ 0, 10, 9, 0, 0, 4, 8}, 
				{ 0, 5, 7, 0, 0, 0, 1}, 
				{ 0, 0, 2, 4, 0, 0, 6}, 
				{ 0, 3, 0, 8, 1, 6, 0}, 
		};
		int N = weight.length;
		List<Edge>[] adjList = new List[N];
		for (int i = 0; i < N; i++) {
			adjList[i] = new LinkedList<>();
			for (int j = 0; j < N; j++) {
				if (weight[i][j] != 0) {
					Edge e = new Edge(j, weight[i][j]);
					adjList[i].add(e);
				}
			}
		}

		PrimMST d = new PrimMST(adjList);

		System.out.println("최소신장트리 간선 :");		
		int[] tree = d.mst(0);	 
		for (int i = 1; i < tree.length; i++) { // 최소신장트리 간선 출력
			System.out.print("("+i+ "," +tree[i]+ ") ");
		}
		System.out.printf("\n\n"); 
		// MST 가중치 합
		int sum = 0;
		for (int i = 1; i < tree.length; i++) {
			for(Edge j: adjList[i]){
				if (j.adjvertex == tree[i]){
					sum += j.weight;
					break;
				}		
			}
		}
		System.out.println("최소신장트리의 간선 가중치 합 = " +sum); 
	}
}

