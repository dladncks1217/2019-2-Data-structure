import java.util.NoSuchElementException;
public class SList <E extends Comparable<E>> {
	
	protected Node head;  // 연결 리스트의 첫 노드 가리킴
	private   int  size;
	public Node getHead() { return head; }
	public void setHead(Node n) { head= n;}
	public SList(){       // 연결 리스트 생성자
		head = null;
		size = 0;
	}
	public int size() { return size; }
	public boolean isEmpty() { return size == 0; }

	public void insertFront(E newItem){ // 연결리스트 맨 앞에 새 노드 삽입
		head = new Node(newItem, head);
		size++;
	}
	
	public void insertAfter(E newItem, Node p){ // 노드 p 바로 다음에 새 노드 삽입
		p.setNext(new Node(newItem, p.getNext()));
		size++;
	}
	
	public void deleteFront(){       // 리스트의 첫 노드 삭제
		if (isEmpty()) throw new NoSuchElementException();
		head = head.getNext();
		size--;
	}
	
	public void deleteAfter(Node p){ // p가 가리키는 노드의 다음 노드를 삭제
		if (p == null) throw new NoSuchElementException();
		Node t = p.getNext();
		p.setNext(t.getNext());
		t.setNext(null);
		size--;
	}

	 public int search(E target) {   // target을 탐색  
		 Node p = head;
		 for (int  k = 0; k < size ;k++){
			 if (target == p.getItem()) return k;
			 p = p.getNext(); 
		 }
		 return -1; // 탐색을 실패한 경우 -1 리턴
	 }
	 public Node mergeTwoLists(Node p1, Node p2){ //연습문제 2-17 두개의 정렬된 리스트 합병
		 Node head = new Node(0, null);
		 Node p = head;
		 while(p1!=null && p2!=null){
			 int c =  p1.getItem().compareTo(p2.getItem());
			 if (c < 0) {
				 p.setNext(p1);
				 p1=p1.getNext();
			 }
			 else{
				 p.setNext(p2);
				 p2=p2.getNext();
			 }
			 p = p.getNext();
		 }
		 if(p1 != null) p.setNext(p1);
		 if(p2 != null) p.setNext(p2);
		 return head.getNext();
	 }

	 public static Node reverseList(Node currentNode){  //연습문제 2-19 역방향 리스트
		 Node previousNode=null;  
		 Node nextNode;  
		 while(currentNode!=null){  
			 nextNode=currentNode.getNext();  
			 currentNode.setNext(previousNode);  // 링크 역으로
			 previousNode=currentNode;  
			 currentNode=nextNode;  
		 }  
		 return previousNode;  
	 }
	 
	 //연습문제 2-20 k와 같거나 작은 리스트와 k보다 큰 리스트로 분리
	 public void splitList(Node p, int k, SList l1, SList l2){ 
		 Node head1 = new Node(0, null);
		 Node head2 = new Node(0, null);
		 Node p1 = head1;
		 Node p2 = head2;
		 while(p !=null){
			 int c =  p.getItem().compareTo(k);
			 if (c <= 0) {
				 p1.setNext(p);
				 p1=p1.getNext();
			 }
			 else{
				 p2.setNext(p);
				 p2=p2.getNext();
			 }
			 p = p.getNext();
		 }
		 p1.setNext(null);
		 p2.setNext(null);
		 l1.setHead(head1.getNext());
		 l2.setHead(head2.getNext());
	 }

	 // 연습문제 2-21 공통된 숫자의 합
	 public int commonSum(SList l2){ 
		 int sum = 0;
		 Node p1 = head;
		 Node p2 = l2.getHead();
		 while(p1 !=null && p2 != null){
			 int c =  p1.getItem().compareTo(p2.getItem());
			 if (c == 0) {
				 sum += (int) p1.getItem();
				 p1=p1.getNext();
				 p2=p2.getNext();
			 }
			 else if (c  < 0) 	p1=p1.getNext();
			 else 				p2=p2.getNext();  
		 }
		 return sum;
	 }

	 // 연습문제 2-22 중간 노드 찾기
	 public Node findMiddleNode(Node head){  
		 Node slowPointer, fastPointer;   
		 slowPointer = fastPointer = head;    
		 while(fastPointer != null) {   
			 fastPointer = fastPointer.getNext();   
			 if(fastPointer != null && fastPointer.getNext() != null) {   
				 slowPointer = slowPointer.getNext();   
				 fastPointer = fastPointer.getNext();   
			 }   
		 }   
		 return slowPointer;
	 } 

	 // 연습문제 2-23 싸이클 검사
	 public boolean cycleDetector() {  
		 Node fastPtr = head;  
		 Node slowPtr = head;  
		 while (fastPtr != null && fastPtr.getNext() != null) {  
			 fastPtr = fastPtr.getNext().getNext();  
			 slowPtr = slowPtr.getNext();  
			 if (slowPtr == fastPtr)  
				 return true;  	  
		 }  
		 return false;  
	 }
	 
	 public void createCycle(){  // 환형리스트 만들기
		 Node p = head;
		 Node q = null;
		 while(p != null){
			 q = p;
			 p = p.getNext();
		 }
		 q.setNext(head);
	 }

	public void print(){  // 연결 리스트 노드들의 항목들을 차례로 출력
		for (Node p = head; p != null; p = p.getNext()) 
			System.out.print(p.getItem()+"\t ");
		System.out.println();
	}
}
