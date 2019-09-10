public class main {
	public static void main(String[] args) {
		RedBlackTree<Integer, String> rbt = new RedBlackTree<Integer, String>();
		rbt.put(700, "strawberry");
		rbt.put(250, "eggplant");
		rbt.put(100, "apple");
		rbt.put(500, "raspberry");
		rbt.put(150, "cherry");
		rbt.put(300, "honeydew");
		rbt.put(900, "watermelon");
		rbt.put(400, "mango");
		rbt.put(450, "pear");
		rbt.put(350, "lime");

		rbt.print();
		rbt.delete(400);
		rbt.print();
	}
}