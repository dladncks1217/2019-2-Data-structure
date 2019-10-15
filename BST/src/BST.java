import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BST {

	public int idata;

	public BST left;
	public BST right;
	public BST parent;

	// variables needed to print the tree like a tree
	int depth = 0;
	int level = 0;
	int drawPos = 0;

	/******** Functions to create a random binary search tree *********/

	

	public static BST createIntegerTree(int numNodes) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BST root = new BST();
		System.out.println("숫자를 입력하세요");
		root.idata = Integer.parseInt(br.readLine());

		int treeSize = countNodes(root);
		while (treeSize < numNodes) {
			int count = numNodes - treeSize;
			while (count-- > 0) {
				System.out.println("숫자를 입력하세요");
				root.insertInteger(Integer.parseInt(br.readLine()));
			}
			treeSize = countNodes(root);
		}
		return root;
	}

	// Inserts a given number into the BST
	void insertInteger(int data) {
		if (this.idata == data)
			return;
		if (this.idata < data) {
			if (this.right == null) {
				this.right = new BST();
				this.right.idata = data;
				this.right.parent = this;
			} else {
				this.right.insertInteger(data);
			}
		} else {
			if (this.left == null) {
				this.left = new BST();
				this.left.idata = data;
				this.left.parent = this;
			} else {
				this.left.insertInteger(data);
			}
		}
	}

	// Creates a  tree and prints it like a tree
	public static void main(String[] args) throws Exception {
		System.out.println("숫자의 개수를 입력하세요");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BST root = createIntegerTree(Integer.parseInt(br.readLine()));
		root.inOrderInteger(", ");
		drawTree(root);
	}

	public void delete(int data) {
		parent = delete(parent,data); 
	}
	private BST delete(BST parent, int data) {
		if(parent==null) {
			return parent;
		}
		if(data<parent.data) {
			
		}
		
	}
	
	/************
	 * Actual functions that print the tree like a tree
	 ********************/
	static void drawTree(BST root) {

		System.out.println("\n\nLevel order traversal of tree:");
		int depth = depth(root);
		setLevels(root, 0);

		int depthChildCount[] = new int[depth + 1];

		LinkedList<BST> q = new LinkedList<BST>();
		q.add(root.left);
		q.add(root.right);

		// draw root first
		root.drawPos = (int) Math.pow(2, depth - 1) * H_SPREAD;
		currDrawLevel = root.level;
		currSpaceCount = root.drawPos;
		System.out.print(getSpace(root.drawPos) + root.idata);

		while (!q.isEmpty()) {
			BST ele = q.pollFirst();
			drawElement(ele, depthChildCount, depth, q);
			if (ele == null)
				continue;
			q.add(ele.left);
			q.add(ele.right);
		}
		System.out.println();
	}

	static int currDrawLevel = -1;
	static int currSpaceCount = -1;
	static final int H_SPREAD = 3;

	static void drawElement(BST ele, int depthChildCount[], int depth, LinkedList<BST> q) {
		if (ele == null)
			return;

		if (ele.level != currDrawLevel) {
			currDrawLevel = ele.level;
			currSpaceCount = 0;
			System.out.println();
			for (int i = 0; i < (depth - ele.level + 1); i++) {
				int drawn = 0;
				if (ele.parent.left != null) {
					drawn = ele.parent.drawPos - 2 * i - 2;
					System.out.print(getSpace(drawn) + "/");
				}
				if (ele.parent.right != null) {
					int drawn2 = ele.parent.drawPos + 2 * i + 2;
					System.out.print(getSpace(drawn2 - drawn) + "\\");
					drawn = drawn2;
				}

				BST doneParent = ele.parent;
				for (BST sibling : q) {
					if (sibling == null)
						continue;
					if (sibling.parent == doneParent)
						continue;
					doneParent = sibling.parent;
					if (sibling.parent.left != null) {
						int drawn2 = sibling.parent.drawPos - 2 * i - 2;
						System.out.print(getSpace(drawn2 - drawn - 1) + "/");
						drawn = drawn2;
					}

					if (sibling.parent.right != null) {
						int drawn2 = sibling.parent.drawPos + 2 * i + 2;
						System.out.print(getSpace(drawn2 - drawn - 1) + "\\");
						drawn = drawn2;
					}
				}
				System.out.println();
			}
		}
		int offset = 0;
		int numDigits = (int) Math.ceil(Math.log10(ele.idata));
		if (ele.parent.left == ele) {
			ele.drawPos = ele.parent.drawPos - H_SPREAD * (depth - currDrawLevel + 1);
			// offset = 2;
			offset += numDigits / 2;
		} else {
			ele.drawPos = ele.parent.drawPos + H_SPREAD * (depth - currDrawLevel + 1);
			// offset = -2;
			offset -= numDigits;
		}

		System.out.print(getSpace(ele.drawPos - currSpaceCount + offset) + ele.idata);
		currSpaceCount = ele.drawPos + numDigits / 2;
	}

	// Utility functions
	public void inOrderInteger(String sep) {
		if (left != null)
			left.inOrderInteger(sep);
		System.out.print(idata + sep);
		if (right != null)
			right.inOrderInteger(sep);
	}

	public static int depth(BST n) {
		if (n == null)
			return 0;
		n.depth = 1 + Math.max(depth(n.left), depth(n.right));
		return n.depth;
	}

	public static int countNodes(BST n) {
		if (n == null)
			return 0;
		return 1 + countNodes(n.left) + countNodes(n.right);
	}

	static void setLevels(BST r, int level) {
		if (r == null)
			return;
		r.level = level;
		setLevels(r.left, level + 1);
		setLevels(r.right, level + 1);
	}

	static String getSpace(int i) {
		String s = "";
		while (i-- > 0)
			s += " ";
		return s;
	}

	
}