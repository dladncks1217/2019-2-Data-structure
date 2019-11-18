import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class BST<Key extends Comparable<Key>, Value>{
	public Node root; 
	public Node getRoot() { return root; }
	public BST(Key newId, Value newName){  // BST 생성자    // get, put, min, deleteMin, delete
		root = new Node(newId, newName);               // 메소드들 선언
		}
	public Value get(Key k) {return get(root, k);}
	public Value get(Node n, Key k) {
		if (n == null)  return null;   // k를 발견 못함
		int t = n.getKey().compareTo(k);
		if (t > 0)   	return get(n.getLeft(), k);  // if (k < 노드 n의 id) 왼쪽 서브 트리 탐색
		else if (t < 0) return get(n.getRight(), k); // if (k > 노드 n의 id) 오른쪽서브 트리 탐색
		else  			return (Value) n.getValue(); // k를 가진 노드 발견
	}
	
	public void put(Key k, Value v) {root = put(root, k, v);}
	public Node put(Node n, Key k, Value v){
		if (n == null)  return new Node(k, v); 
		int t = n.getKey().compareTo(k);
		if (t > 0)  n.setLeft(put(n.getLeft(), k, v));       // if (k < 노드 n의 id) 왼쪽 서브 트리에 삽입
		else if (t < 0) n.setRight(put(n.getRight(), k, v)); // if (k > 노드 n의 id) 오른쪽 서브 트리에 삽입
		else n.setValue(v); // 노드 n의 name을v로 갱신
		return n;
	}
	
	public Key min() { 
		if (root == null) return null;
		return (Key) min(root).getKey();}
	private Node min(Node n) {
		if (n.getLeft() == null)  return n;
		return min(n.getLeft());
	}
	
	public void deleteMin() {
		if (root == null) System.out.println("empty 트리");
		root = deleteMin(root);}
	public Node deleteMin(Node n) {
		if (n.getLeft() == null) return n.getRight(); 	// if (n의 왼쪽 자식==null) n의 오른쪽 자식 리턴
		n.setLeft(deleteMin(n.getLeft())); 				// if (n의 왼쪽 자식≠null), n의 왼쪽 자식으로 재귀 호출
		return n;
	}
	
	public void deleteMax() {
        if (root == null)  System.out.println("empty 트리");
        root = deleteMax(root);}
    private Node deleteMax(Node n) {
        if (n.getRight() == null) return n.getLeft();
        n.setRight(deleteMax(n.getRight()));
        return n;
    }
    
	public void delete(Key k) {root = delete(root, k);} 
	public Node delete(Node n, Key k) {
		if (n==null) return null;  
		int t = n.getKey().compareTo(k);
		if (t > 0)      n.setLeft(delete(n.getLeft(), k));   // if (k < 노드 n의 id) 왼쪽 자식으로 이동
		else if (t < 0) n.setRight(delete(n.getRight(), k)); // if (k > 노드 n의 id) 오른쪽 자식으로 이동
		else {  // 삭제할 노드 발견
			if (n.getRight() == null) return n.getLeft();  // case 0, 1 
			if (n.getLeft()  == null) return n.getRight(); // case 1
			Node target = n;   // case 2 Line10-13  
			n = min(target.getRight()); // 삭제할 노드 자리로 옮겨올 노드 찾아서 n이 가리키게 함
			n.setRight( deleteMin(target.getRight()));
			n.setLeft(target.getLeft());
		}
		return n;
	} 
 
    public int height() {return height(root)+1;}
    private int height(Node n) {
        if (n == null) return -1;
        return 1 + Math.max(height(n.getLeft()), height(n.getRight()));
    }
    
	public void print(Node root) {
		System.out.printf("\ninorder:\n");
		inorder(root);
		System.out.printf("\npreorder:\n");
		preorder(root);
		System.out.printf("\nlevel order:\n");
		levelorder(root);
	}
	public void inorder(Node n){       // 중위 순회
		if (n != null) {
			inorder(n.getLeft());   // n의 왼쪽 서브 트리를 순회하기 위해
			System.out.print(n.getKey()+" ");  // 노드 n 방문
			inorder(n.getRight());  // n의 오른쪽 서브 트리를 순회하기 위해
		}
	}
	public void levelorder(Node root) { // 레벨 순회
		Queue<Node> q = new LinkedList<Node>(); // 큐 자료구조 이용
		Node t;
		q.add(root);  // 루트 노드 큐에 삽입
		while (!q.isEmpty()) { 
			t = q.remove();   //큐에서 가장 앞에 있는 노드 제거
			System.out.print(t.getKey()+" "); // 제거된 노드 출력(방문)
			if (t.getLeft() != null)      // 제거된 왼쪽 자식이 null이 아니면
				q.add(t.getLeft());       // 큐에 왼쪽 자식 삽입
			if (t.getRight() != null)     // 제거된 오른쪽 자식이 null이 아니면
				q.add(t.getRight());      // 큐에  오른쪽 자식 삽입
		} 
	}
	public void preorder(Node n) {     // 전위 순회
		if (n != null) {
			System.out.print(n.getKey()+" ");  // 노드 n 방문
			preorder(n.getLeft());  // n의 왼쪽    서브 트리를 순회하기 위해
			preorder(n.getRight()); // n의 오른쪽 서브 트리를 순회하기 위해
		}
	}
}

