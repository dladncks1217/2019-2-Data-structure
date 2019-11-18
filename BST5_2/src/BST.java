import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class BST<Key extends Comparable<Key>, Value>{
	public Node root; 
	public Node getRoot() { return root; }
	public BST(Key newId, Value newName){  // BST ������    // get, put, min, deleteMin, delete
		root = new Node(newId, newName);               // �޼ҵ�� ����
		}
	public Value get(Key k) {return get(root, k);}
	public Value get(Node n, Key k) {
		if (n == null)  return null;   // k�� �߰� ����
		int t = n.getKey().compareTo(k);
		if (t > 0)   	return get(n.getLeft(), k);  // if (k < ��� n�� id) ���� ���� Ʈ�� Ž��
		else if (t < 0) return get(n.getRight(), k); // if (k > ��� n�� id) �����ʼ��� Ʈ�� Ž��
		else  			return (Value) n.getValue(); // k�� ���� ��� �߰�
	}
	
	public void put(Key k, Value v) {root = put(root, k, v);}
	public Node put(Node n, Key k, Value v){
		if (n == null)  return new Node(k, v); 
		int t = n.getKey().compareTo(k);
		if (t > 0)  n.setLeft(put(n.getLeft(), k, v));       // if (k < ��� n�� id) ���� ���� Ʈ���� ����
		else if (t < 0) n.setRight(put(n.getRight(), k, v)); // if (k > ��� n�� id) ������ ���� Ʈ���� ����
		else n.setValue(v); // ��� n�� name��v�� ����
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
		if (root == null) System.out.println("empty Ʈ��");
		root = deleteMin(root);}
	public Node deleteMin(Node n) {
		if (n.getLeft() == null) return n.getRight(); 	// if (n�� ���� �ڽ�==null) n�� ������ �ڽ� ����
		n.setLeft(deleteMin(n.getLeft())); 				// if (n�� ���� �ڽġ�null), n�� ���� �ڽ����� ��� ȣ��
		return n;
	}
	
	public void deleteMax() {
        if (root == null)  System.out.println("empty Ʈ��");
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
		if (t > 0)      n.setLeft(delete(n.getLeft(), k));   // if (k < ��� n�� id) ���� �ڽ����� �̵�
		else if (t < 0) n.setRight(delete(n.getRight(), k)); // if (k > ��� n�� id) ������ �ڽ����� �̵�
		else {  // ������ ��� �߰�
			if (n.getRight() == null) return n.getLeft();  // case 0, 1 
			if (n.getLeft()  == null) return n.getRight(); // case 1
			Node target = n;   // case 2 Line10-13  
			n = min(target.getRight()); // ������ ��� �ڸ��� �Űܿ� ��� ã�Ƽ� n�� ����Ű�� ��
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
	public void inorder(Node n){       // ���� ��ȸ
		if (n != null) {
			inorder(n.getLeft());   // n�� ���� ���� Ʈ���� ��ȸ�ϱ� ����
			System.out.print(n.getKey()+" ");  // ��� n �湮
			inorder(n.getRight());  // n�� ������ ���� Ʈ���� ��ȸ�ϱ� ����
		}
	}
	public void levelorder(Node root) { // ���� ��ȸ
		Queue<Node> q = new LinkedList<Node>(); // ť �ڷᱸ�� �̿�
		Node t;
		q.add(root);  // ��Ʈ ��� ť�� ����
		while (!q.isEmpty()) { 
			t = q.remove();   //ť���� ���� �տ� �ִ� ��� ����
			System.out.print(t.getKey()+" "); // ���ŵ� ��� ���(�湮)
			if (t.getLeft() != null)      // ���ŵ� ���� �ڽ��� null�� �ƴϸ�
				q.add(t.getLeft());       // ť�� ���� �ڽ� ����
			if (t.getRight() != null)     // ���ŵ� ������ �ڽ��� null�� �ƴϸ�
				q.add(t.getRight());      // ť��  ������ �ڽ� ����
		} 
	}
	public void preorder(Node n) {     // ���� ��ȸ
		if (n != null) {
			System.out.print(n.getKey()+" ");  // ��� n �湮
			preorder(n.getLeft());  // n�� ����    ���� Ʈ���� ��ȸ�ϱ� ����
			preorder(n.getRight()); // n�� ������ ���� Ʈ���� ��ȸ�ϱ� ����
		}
	}
}
