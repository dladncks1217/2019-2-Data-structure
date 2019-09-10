public class Huffman {

	private Entry[] a;      // a[0]은 사용 안함
	private int N;          // 힙의 크기

	public Huffman(Entry[] harray, int initialSize) {  // 생성자  
		a = harray;
		N = initialSize;
	}

	public int size() { return N; } // 힙의 크기 리턴
	
	public void createHeap() {      // 최소힙 만들기
		for(int i = N/2; i > 0; i--){
			downheap(i);
		}
	}	
	public Entry createTree(){
		while (size() > 1){       // 힙에 1개의 노드만 남을 때까지
			Entry e1 = deleteMin();  // 힙에서 최소 빈도수 가진 노드 제거하여 e1이 참조
			Entry e2 = deleteMin();  // 힙에서 최소 빈도수 가진 노드 제거하여 e2이 참조
			Entry temp = new Entry(e1.getKey()+e2.getKey(),     // e1과 e2의 빈도수를 합산
					               e1.getValue()+e2.getValue(), // string 이어붙이기
					               e1, e2, " ");	// e1,e2가 각각 새노드의 왼쪽,오른쪽 자식 
			insert(temp);   // 새 노드를 힙에 삽입
		}
		return deleteMin(); // 1개 남은 노드(루트 노드)를 힙에서 제거하며 리턴
	}
	
	public void preorder(Entry node){ // 전위순회하며 허프만 코드를 만들고, 각 이파리 노드에서 코드 출력
		if (node.getLeft() != null){
			node.getLeft().setCode(node.getCode()+"0");  // 왼쪽으로 내려가면 코드에 0 추가
			preorder(node.getLeft());
		}
		if (node.getRight() != null){
			node.getRight().setCode(node.getCode()+"1"); // 오른쪽으로 내려가면 코드에 1 추가
			preorder(node.getRight());
		}
		if(node.getValue().length() == 1){     // 현재 노드가 이파리 노드이면, 허프만 코드 출력
			System.out.print(node.getValue()+":"+node.getCode()+"  ");
		}
	}

	public void insert(Entry newEntry) {
		a[++N] = newEntry;        // 새로운 키를 배열 마지막 원소 다음에 저장
		upheap(N);                // 위로 올라가며 힙 속성 회복시키기 위해
	} 

	public Entry deleteMin() {
		Entry max = a[1];     // a[1]의 최대값을 max로
		swap(1, N--);         // 힙의 마지막 항목과 교환하고 힙 크기를 1 감소
		a[N+1] = null;        // 마지막 항목을 null로 처리
		downheap(1);          // 힙 속성을 회복시키기 위해
		return max;
	}

	private boolean greater(int i, int j) {  
		return a[i].getKey()> a[j].getKey();  }
	
	private void swap(int i, int j) { // a[i]와 a[j]를 교환
		Entry temp = a[i];   a[i] = a[j];   a[j] = temp; }
	
	private void downheap(int i) {   // i는 현재 노드의 인덱스
		while (2*i <= N) {           // i의 왼쪽 자식노드가 힙에 있으면
			int k = 2*i;             // k는 왼쪽 자식노드의 인덱스
			if (k < N && greater(k, k+1)) k++; //왼쪽과 오른쪽자식의 숭자를 결정하여 k가 승자의 인덱스가됨
			if (!greater(i, k)) break;  // 현재 노드가 자식 승자와 같거나 크면 루프를 중단하고
			swap(i, k);              // 현재 노드가 자식 승자보다 작으면 현재 노드와 자식 승자와 교환
			i = k;                   // 자식 승자가 현재 노드가 되어 다시 반복하기 위해
		}
	}

	private void upheap(int j) {           // j는 현재 노드의 인덱스
		while (j > 1 && greater(j/2, j)) { // 현재노드가 루트가 아니고 동시에 부모가 작으면
			swap(j/2, j);                  // 부모와 현재 노드 교환
			j = j/2;                       // 부모가 현재 노드가 되어 다시 반복하기 위해
		}
	}

	public void print(){  // 힙 출력
		for (int i = 1; i < N+1; i++) {
			System.out.printf("["+a[i].getKey()+" "+a[i].getValue() + "] ");
		}
		System.out.println(); 
	}
}
