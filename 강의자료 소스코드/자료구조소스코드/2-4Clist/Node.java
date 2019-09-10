public class Node <E>{
	private E    item;
	private Node next;
	
	public Node(E newItem, Node p){ // 持失切
		item  = newItem;
		next  = p;
	}
	// get 五社球人 set 五社球
	public E    getItem()    { return item;}
    public Node getNext()    { return next;}
    public void setItem(E newItem)      { item = newItem;}
    public void setNext(Node newNext) 	{ next = newNext;}
}
