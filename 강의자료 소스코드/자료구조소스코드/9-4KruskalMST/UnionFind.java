public class UnionFind {  
	protected  int[] p;    // 배열크기는 정점의 수 N이고 p[i]는 i의 부모 원소를 저장한다. 
	protected  int[] rank; 
	
	public UnionFind(int N) {
		p = new int[N];
		rank = new int[N];
		for (int i = 0; i < N; i++) {
			p[i]    = i;  // 초기엔 N개의 트리가 각각 i 자기 자신이 부모이기 떄문에 
			rank[i] = 0;  // 초기엔 N개의 트리 각각의 rank를 0으로 초기화 
		}
	}
	//i가 속한 집합의 루트노드를 재귀적으로 찾고 최종적으로 경로상의 각 원소의 부모를 루트노드로 만든다.
	protected int find(int i) { // 경로 압축
		if ( i != p[i])   
			p[i] = find(p[i]);  //리턴하며 경로상의 각 노드의 부모가 루트가되도록 만든다.
		return p[i];
	}
	//i와 j가 같은 트리에 있는지를 검사
	public boolean isConnected(int i, int j) {
		return find(i) == find(j); 
	}
	public void union(int i, int j) {  // Union 연산
		int iroot = find(i);
		int jroot = find(j);
		if (iroot == jroot) return;  // 루트노드가 동일하면 더이상의 수행없이 그대로 리턴
		// rank가 높은 루트노드가 승자로 union을 수행한다.
		if (rank[iroot] > rank[jroot]) 
			p[jroot] = iroot;               // iroot가 승자
		else if (rank[iroot] < rank[jroot]) 
			p[iroot] = jroot;               // jroot가 승자
		else {
			p[jroot] = iroot;  // 둘중에 하나 임의로 승자
			rank[iroot]++;     // iroot의 rank 1 증가
		}
	}
}
