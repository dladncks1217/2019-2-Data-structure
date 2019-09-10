import java.util.*;
public class RedBlackTree<Key extends Comparable<Key>, Value> {
	private static final boolean RED   = true;
	private static final boolean BLACK = false;
	private Node root;    
	private class Node {  // Node 클래스
		Key     id;
		Value   name;
		Node    left, right;
		boolean color;  // 부모노드 link의 색
		public Node(Key k, Value v, boolean col) {  // 노드 생성자
			id    = k;
			name  = v;
			color = col;
			left = right = null;
		}
	}	
	private boolean isEmpty(){ return root == null;}
	private boolean isRed(Node n) {
		if (n == null) return false; // null의 색은 블랙             
		return (n.color == RED);                         
	}

	public Value get(Key k) {return get(root, k);} // 탐색 연산, 5-4-2절
	public Value get(Node n, Key k) {
		if (n == null) return null;   // 탐색 실패
		int t = n.id.compareTo(k);
		if (t > 0) 	    return get(n.left,  k); // if (k < 노드 n의 id) 왼쪽 서브트리  탐색
		else if (t < 0) return get(n.right, k); // if (k > 노드 n의 id) 오른쪽서브트리 탐색
		else 	        return (Value) n.name; 	// 탐색 성공 
	}
 
	private Node rotateLeft(Node n){
		Node x  = n.right;  		
		n.right = x.left;		
		x.left  = n;         		
		x.color = n.color; 	
		n.color = RED;     		
		return x; 
	} 

	private Node rotateRight(Node n){
		Node x  = n.left;    	
		n.left  = x.right;   		
		x.right = n;        		
		x.color = n.color; 	
		n.color = RED;     	
		return x;
	}
	
	private void flipColors(Node n){
		n.color = !n.color;		
		n.left.color  = !n.left.color;	
		n.right.color = !n.right.color;	  
	}    
	
	public void put(Key k, Value v) {   // 삽입 연산, 5-4-4절
		root = put(root, k, v);
		root.color = BLACK;
	}
	private Node put(Node n, Key k, Value v) { 
		if (n == null)  return new Node(k, v, RED); // 새로운 레드 노드 생성
		int t = k.compareTo(n.id);
		if (t < 0)      n.left  = put(n.left,  k, v); 
		else if (t > 0) n.right = put(n.right, k, v); 
		else            n.name  = v;   // k가 트리에 있는 경우 v로 name을 갱신
		// 오른쪽 link가 레드인 경우 바로잡는다.
		if (!isRed(n.left) && isRed(n.right))      	n = rotateLeft(n);
		if (isRed(n.left)  && isRed(n.left.left)) 	n = rotateRight(n);
		if (isRed(n.left)  && isRed(n.right))     	flipColors(n);
		return n;
	}
	
	private Node moveRedLeft(Node n){
		flipColors(n);      // case 1 과 case 2
		if (isRed(n.right.left)) {  // case 2
			n.right = rotateRight(n.right);
			n       = rotateLeft(n);
			flipColors(n);
		}
		return n;
	}
	
	public void deleteMin() { // 최솟값 삭제, 5-4-5절
		root = deleteMin(root);
		root.color = BLACK;
	}
	private Node deleteMin(Node n) {
		if (n.left == null)  return null;
		if (!isRed(n.left) && !isRed(n.left.left))
			n = moveRedLeft(n); 
		n.left = deleteMin(n.left);
		return fixUp(n);
	}
	
	private Node moveRedRight(Node n){
		flipColors(n);             // case 1 과 case 2
		if (isRed(n.left.left)) {  // case 2
			n = rotateRight(n);
			flipColors(n);
		}
		return n;
	}
	
	private Node fixUp(Node n) {
		if (isRed(n.right))   n = rotateLeft(n);
		if (isRed(n.left) && isRed(n.left.left))  n = rotateRight(n);
		if (isRed(n.left) && isRed(n.right))  flipColors(n);
		return n;
	}
	
	public Key min() {   // 최솟값 찾기
		if (isEmpty()) return null;
		return (Key) min(root).id;
	}
	private Node min(Node n) {
		if (n.left == null) return n;
		return min(n.left);
	}

	public void delete(Key k) { // 삭제 연산
		root = delete(root, k);
		root.color = BLACK;
	}
	private Node delete(Node n, Key k) { // 노드n으로부터 키값 k를 가진 노드 삭제
		if (k.compareTo(n.id) < 0)  {    // k가 노드n의 id보다 작으면
			if (!isRed(n.left) && !isRed(n.left.left))  
				n = moveRedLeft(n);      // 왼쪽으로 레드 link 내려 보내기
			n.left = delete(n.left, k);  // k를 찾기 위해 완쪽 서브트리로 내려감
		}
		else { // k가 노드n의 id와 같거나 크면
			if (isRed(n.left))      // n의 왼쪽 자식이 레드이면
				n = rotateRight(n); // 오른쪽으로 레드 link 내려 보내기
			if (k.compareTo(n.id) == 0 && (n.right == null)) // n이 이파리노드일때
				return null;        // 이파리 노드 n 삭제
			if (!isRed(n.right) && !isRed(n.right.left))     // 오른쪽으로 레드 link 내려 보내기
				n = moveRedRight(n);
			if (k.compareTo(n.id) == 0) {       // 노드 n의 중위후속자 노드 정보를 복사하고 삭제함 
				Node successor = min(n.right);  // successor가 노드 n의 중위후속자 노드
				n.name  = get(n.right, successor.id); // 노드n에 successor노드 name 복사
				n.id    = successor.id;               // 노드n에 successor노드   id  복사
				n.right = deleteMin(n.right);         // successor노드 삭제
			}
			else 
				n.right = delete(n.right, k);         // k를 찾기 위해 오른쪽 서브트리로 내려감
		}
		return fixUp(n);  // 직전 호출 노드로 리턴하며, 위배된 트리 조건 바로잡기
	}
	
	public void print()  {  // 트리 출력
		System.out.printf("\ninorder:\n");
		inorder(root);
		System.out.printf("\npreorder:\n");
		preorder(root);
		System.out.printf("\nlevel order:\n");
		levelorder(root);
	}
	public void inorder(Node n){       // 중위 순회
		if (n != null) {
			inorder(n.left);   // n의 왼쪽 서브 트리를 순회하기 위해
			System.out.print(n.id+" ");  // 노드 n 방문
			inorder(n.right);  // n의 오른쪽 서브 트리를 순회하기 위해
		}
	}
	public void levelorder(Node root) { // 레벨 순회
		Queue<Node> q = new LinkedList<Node>(); // 큐 자료구조 이용
		Node t;
		q.add(root);  // 루트 노드 큐에 삽입
		while (!q.isEmpty()) { 
			t = q.remove();   //큐에서 가장 앞에 있는 노드 제거
			System.out.print(t.id+" "); // 제거된 노드 출력(방문)
			if (t.left != null)      // 제거된 왼쪽 자식이 null이 아니면
				q.add(t.left);       // 큐에 왼쪽 자식 삽입
			if (t.right != null)     // 제거된 오른쪽 자식이 null이 아니면
				q.add(t.right);      // 큐에  오른쪽 자식 삽입
		} 
	}
	public void preorder(Node n) {     // 전위 순회
		if (n != null) {
			System.out.print(n.id+" ");  // 노드 n 방문
			preorder(n.left);  // n의 왼쪽    서브 트리를 순회하기 위해
			preorder(n.right); // n의 오른쪽 서브 트리를 순회하기 위해
		}
	}	
}
