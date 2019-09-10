public class BellmanFord {
	public static final int INF = Integer.MAX_VALUE;
    private int D[];
    private int previous[];  // 경로 추출을 위해
    private int N;
 
    public BellmanFord(int numOfVertices) { // 생성자
        N = numOfVertices;
        D = new int[N];          // 최단거리 저장
        previous = new int[N];   // 최단경로 추출하기 위해
    }
 
    public void shortestPath(int s, int adjMatrix[][]) {
        for (int i = 0; i < N; i++) 
        	D[i] = INF;  //초기화
        D[s] = 0; previous[s] = 0;
        for (int k = 0; k < N-1; k++) {  // 총 N-1번 반복
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) { 
                	if (adjMatrix[i][j] != INF) { 
                		if (D[j] > D[i] + adjMatrix[i][j]){  
                            D[j] = D[i] + adjMatrix[i][j];  // 간선 완화 
                		    previous[j] = i;  // i 덕분에 j까지 거리가  단축됨
                		}
                    }
                }
            }
        }
 /*       // 1번 더 간선완화 시도하여 갱신이 발생하면 음수싸이클 존재
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) { 
            	if (adjMatrix[i][j] != INF) { 
            		if (D[j] > D[i] + adjMatrix[i][j])
                        System.out.println("음수싸이클 있음");
                }
            }
        }*/
    }
    public void printPaths(int s){   // 결과 출력
    	System.out.println("정점 "+s +"으로부터의 최단거리");
    	for (int i = 1; i < N; i++) {
    		System.out.printf("[%d,%d] = %3d",s,i,D[i]);
    		System.out.println();
    	}
    	System.out.println();
		System.out.println("정점 0으로부터의 최단경로");
		for (int i = 1; i < N; i++){
			int back = i;
			System.out.print(back);
			while (back!= 0) {
				System.out.print("<-" + previous[back]);
				back = previous[back];
			}
			System.out.println();
		}
    }
}
