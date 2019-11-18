package BST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class AVL5_1<Key extends Comparable<Key>, Value> {
   private Node root;
   public class Node {
      private Key id;          
      private Value name;      
      private int height;      
      private Node left, right;  
      public Node(Key newID, Value newName, int newHt) { // ������
         id = newID;
         name = newName;
         height = newHt;
         left = right = null;
      }
   }

   private int height(Node n) { // ���� ��� 
      if (n == null) return 0;
      return n.height;
   }

   public void put(Key k, Value v) {root = put(root, k, v);}  // ���� ����
   private Node put(Node n, Key k, Value v) {
      if (n == null)    return new Node(k, v, 1);
      int t = k.compareTo(n.id);
      if (t < 0)       n.left  = put(n.left,  k, v);
      else if (t > 0) n.right = put(n.right, k, v);
      else {
         n.name = v;  // k�� �̹� Ʈ���� �����Ƿ� Value v�� ����
         return n;
      }
      n.height = tallerHeight(height(n.left), height(n.right)) + 1;
      return balance(n); // ��� n�� ���� ���� �� �ұ����� �ٷ� ����
   }

   private Node balance(Node n) { // �ұ��� ó��
      if (bf(n) > 1) {  //��� n�� ���� ����Ʈ���� ���Ƽ� �ұ��� �߻�
         if (bf(n.left) < 0) { // ��� n�� �����ڽĳ���� �����ʼ���Ʈ���� ���� ���
            n.left = rotateLeft(n.left);    // LR-ȸ��
         }
         n = rotateRight(n);  // LL-ȸ��
      }
      else if (bf(n) < -1) {  //��� n�� ������ ����Ʈ���� ���Ƽ� �ұ��� �߻�
         if (bf(n.right) > 0) {  // ��� n�� �������ڽĳ���� ���� ����Ʈ���� ���� ���
            n.right = rotateRight(n.right); // RL-ȸ��
         }
         n = rotateLeft(n);  // RR-ȸ��
      }
      return n;
   }

   private int bf(Node n) {  // bf ���
      return height(n.left) - height(n.right);  // bf = ���� ����Ʈ�� ���� - ������ ����Ʈ�� ����    
   }

   private Node rotateRight(Node n) {  //��� ȸ��
      Node x = n.left;
      n.left = x.right;
      x.right = n;
      n.height = tallerHeight(height(n.left), height(n.right)) + 1; // ���� ����
      x.height = tallerHeight(height(x.left), height(x.right)) + 1; // ���� ����
      return x;  // ȸ�� �� x�� n�� ���� �ڸ��� �̵��Ǿ����Ƿ� 
   }

   private Node rotateLeft(Node n) {   //�·� ȸ��
      Node x = n.right;
      n.right = x.left;
      x.left = n;
      n.height = tallerHeight(height(n.left), height(n.right)) + 1; // ���� ����
      x.height = tallerHeight(height(x.left), height(x.right)) + 1; // ���� ����
      return x;  // ȸ�� �� x�� n�� ���� �ڸ��� �̵��Ǿ����Ƿ� 
   }

   private int tallerHeight(int x, int y){  // ���� ��
      if (x>y) return x;
      else return y;
   }

   public void delete(Key k) {   root = delete(root, k);}  // ���� ����
   private Node delete(Node n, Key k) {
      int t = k.compareTo(n.id);
      if (t < 0)       n.left  = delete(n.left, k);
      else if (t > 0) n.right = delete(n.right, k);
      else {
         if (n.left == null)       return n.right;
         else if (n.right == null) return n.left;
         else {
            Node y = n;
            n = min(y.right);
            n.right = deleteMin(y.right);
            n.left = y.left;
         }
      }
      n.height = tallerHeight(height(n.left), height(n.right)) + 1;
      return balance(n);
   }

   public void deleteMin() {root = deleteMin(root);}  // �ּڰ� ����
   private Node deleteMin(Node n) {
      if (n.left == null) return n.right;
      n.left = deleteMin(n.left);
      n.height = tallerHeight(height(n.left), height(n.right)) + 1;
      return balance(n);
   }

   public Key min() {return min(root).id;}  // �ּڰ� ã��
   private Node min(Node n) {
      if (n.left == null) return n;
      return min(n.left);
   }

   public void print(Node root)  {  // Ʈ�� ���
      System.out.printf("\ninorder:\n");
      inorder(root);
      System.out.printf("\npreorder:\n");
      preorder(root);
      System.out.printf("\nlevel order:\n");
      levelorder(root);
   }
   public void inorder(Node n){       // ���� ��ȸ
      if (n != null) {
         inorder(n.left);   // n�� ���� ���� Ʈ���� ��ȸ�ϱ� ����
         System.out.print(n.id+" ");  // ��� n �湮
         inorder(n.right);  // n�� ������ ���� Ʈ���� ��ȸ�ϱ� ����
      }
   }
   public void levelorder(Node root) { // ���� ��ȸ
      Queue<Node> q = new LinkedList<Node>(); // ť �ڷᱸ�� �̿�
      Node t;
      q.add(root);  // ��Ʈ ��� ť�� ����
      while (!q.isEmpty()) { 
         t = q.remove();   //ť���� ���� �տ� �ִ� ��� ����
         System.out.print(t.id+" "); // ���ŵ� ��� ���(�湮)
         if (t.left != null)      // ���ŵ� ���� �ڽ��� null�� �ƴϸ�
            q.add(t.left);       // ť�� ���� �ڽ� ����
         if (t.right != null)     // ���ŵ� ������ �ڽ��� null�� �ƴϸ�
            q.add(t.right);      // ť��  ������ �ڽ� ����
      } 
   }
   public void preorder(Node n) {     // ���� ��ȸ
      if (n != null) {
         System.out.print(n.id+" ");  // ��� n �湮
         preorder(n.left);  // n�� ����    ���� Ʈ���� ��ȸ�ϱ� ����
         preorder(n.right); // n�� ������ ���� Ʈ���� ��ȸ�ϱ� ����
      }
   }   
   

   public static void main(String[] args) {
      AVL5_1<Integer, String> st = new AVL5_1<Integer, String>();

      st.put(1, "One"); 
      st.put(2, "Two"); 
      st.put(3, "Three"); 
      st.put(4, "Four");
       st.put(5, "Five"); 
       st.put(6, "Six"); 
       st.put(7, "Seven");
       
       st.print(st.root);
   }
}