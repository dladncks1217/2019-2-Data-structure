public class main {
	public static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) {	   
		int[][] weight = {    // [그림 9-5-6](a)의 입력그래프
				{ INF,   1, INF,   2, INF, INF, INF, INF},
				{ INF, INF,   4,  -2, INF,   6, INF, INF}, 
				{ INF, INF, INF, INF, INF, INF, INF,   2}, 
				{ INF, INF, INF, INF,  -1, INF, INF, INF}, 
				{ INF, INF, INF, INF, INF, INF,   4, INF}, 
				{ INF, INF,   1, INF, INF, INF, INF, INF}, 
				{ INF, INF,  -1, INF, INF, INF, INF,   1}, 
				{ INF, INF, INF, INF, INF,   3, INF, INF}
		};
		int N = weight.length; // 그래프 정점의 수  
		
		int s = 0; // 출발점
		BellmanFord bf = new BellmanFord(N);  // 객체 생성
		bf.shortestPath(s, weight);  		  // 최단경로 찾기
		bf.printPaths(s);            		  // 결과 출력
	}
}
