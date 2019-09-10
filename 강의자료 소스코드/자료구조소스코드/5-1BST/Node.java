public class Node <Key extends Comparable<Key>, Value> {
	private Key   id;
	private Value name;
	private Node  left, right;

	public Node(Key newId, Value newName) { // 노드 생성자
		id   = newId;
		name = newName;
		left = right = null;
	}
	// get과 set 메소드들
	public Key getKey()  	{ return id; }
	public Value getValue() { return name; }
	public Node getLeft() 	{ return left; }
	public Node getRight() 	{ return right;}
	public void setKey(Key     newId)  	{ id    = newId; }
	public void setValue(Value newName) { name  = newName; }
	public void setLeft(Node   newLeft) { left  = newLeft; }
	public void setRight(Node  newRight){ right = newRight;}
}
