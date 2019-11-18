
public class main {

	public static void main(String[] args) {
		 BST t = new BST(5,"Five");  

	      t.put(2,"Two");
	      t.put(1, "One");
	      t.put(3, "Three");
	      t.put(7, "Seven");
	      t.put(6, "Six");
	      
	      t.print(t.root);System.out.println();
	      System.out.println("높이 = "+ t.height());
	      
	      
	      t.delete(5);
	      t.print(t.root);System.out.println();
	      System.out.println("높이 = "+ t.height());
	}
}