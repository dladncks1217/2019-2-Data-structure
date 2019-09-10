import java.util.NoSuchElementException;
public class CList <E> {
	private Node last; // 리스트의 마지막 노드(항목)을 가리킨다. 
	private int  size; // 리스트의 항목(노드) 수
	
	public CList() {  // 리스트 생성자
		last = null;
		size = 0;
	}
	
	public int size() { return size;}
	public boolean isEmpty() { return size == 0;}
	
	public void insert(E newItem) {  // last가 가리키는 노드의 다음에 새노드 삽입
		Node newNode = new Node(newItem, null);  // 새 노드 생성
		if  (last == null) {      // 리스트가 empty일때
			newNode.setNext(newNode);
			last = newNode;
			}
		else {
			newNode.setNext(last.getNext()); // newNode의 다음 노드가 last가 가리키는 노드의 다음노드가 되도록
			last.setNext(newNode); // last가 가리키는 노드의 다음 노드가 newNode가 되도록
		}
		size++;
	}
	
	public Node delete() {  // last가 가리키는 노드의 다음 노드를 제거
		if (isEmpty()) throw new NoSuchElementException();
		Node x = last.getNext();       // x가 리스트의 첫 노드를 가리킴
		if  (x == last) last = null;   // 리스트에 1개의 노드만 있는 경우
		else {
			last.setNext(x.getNext()); // last가 가리키는 노드의 다음 노드가 x의 다음 노드가 되도록
			x.setNext(null);           // x의 next를 null로 만든다.
		}
		size--;
		return x;
	}

	public void print(){  // 연결 리스트 노드들의 항목들을 차례로 출력
		if (size > 0){
			int i = 0;
			for (Node p = last.getNext(); i<size ; p = p.getNext(), i++) 
					System.out.print(p.getItem()+"\t ");
		}
		else
			System.out.println("리스트 비어있음.");
	}
}
