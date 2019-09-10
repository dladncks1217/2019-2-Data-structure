import java.util.*;
public class main {
	public static void main(String[] args) {
		int N = 9;
		List<Integer>[] adjList = new List[N];
		for (int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<>();
		}
		adjList[2].add(0);     adjList[2].add(1);    adjList[0].add(1);
		adjList[1].add(3);     adjList[1].add(4);    adjList[4].add(5);
		adjList[5].add(3);     adjList[5].add(7);    adjList[3].add(6);
		adjList[6].add(7);     adjList[7].add(8);
		
		TopologicalSort t = new TopologicalSort(adjList);
		List<Integer> sortedSeq = t.tsort();
	    System.out.printf("위상 정렬:\n");
		System.out.println(sortedSeq);  // 위상 정렬 출력
	}
}
