import java.util.*;
public class main {
	public static void main(String[] args) {
		int[][] weight = { // [그림 9-4-2](a)의 그래프
				{ 0,15,7,9,4,0,0},
				{ 15,0,10,3,0,0,6}, 
				{ 7,10,0,0,0,0,0}, 
				{ 9,3,0,0,8,1,7}, 
				{ 4,0,0,8,0,13,0}, 
				{ 0,0,0,1,13,0,5}, 
				{ 0,6,0,7,0,5,0}, 
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

