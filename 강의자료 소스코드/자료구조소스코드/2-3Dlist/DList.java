import java.util.NoSuchElementException;
public class DList <E> {
	 protected DNode head, tail;
     protected int size;
     
     public DList(){  //생성자
         head = new DNode (null, null, null);
         tail = new DNode (null, head, null);  // tail의 이전 노드를 head로 만든다.
         head.setNext(tail);  //head의 다음 노드를 tail로 만든다.
         size = 0;
     }
     
     public int size() { return size; }
     public boolean isEmpty() { return size == 0; }
   
     public void insertBefore(DNode p, E newItem){ // p가 가리키는 노드 앞에 삽입
    	 DNode t = p.getPrevious();
    	 DNode newNode = new DNode(newItem, t, p);
    	 p.setPrevious(newNode);
    	 t.setNext(newNode);
    	 size++;
     }
     
     public void insertAfter(DNode p, E newItem){ // p가 가리키는 노드 뒤에 삽입
    	 DNode t = p.getNext();
      	 DNode newNode = new DNode(newItem, p, t);
    	 t.setPrevious(newNode);
    	 p.setNext(newNode);
    	 size++;
     }  
          
     public void delete(DNode x) {                // x가 가리키는 노드 삭제
 		if (x ==  null) throw new NoSuchElementException();
    	 DNode f = x.getPrevious();
    	 DNode r = x.getNext();
    	 f.setNext(r);
    	 r.setPrevious(f);
    	 x.setPrevious(null);  // x의 previous를 null로 만든다.
    	 x.setNext(null);      // x의 next를 null로 만든다.
    	 size--;
     }

     public void print(){  // 연결 리스트 노드들의 item들을 차례로 출력
 		if (size > 0) 
 			for (DNode p = head.getNext(); p != tail; p = p.getNext()) 
 					System.out.print(p.getItem()+"\t ");
 		else
 			System.out.println("리스트 비어있음");
 		System.out.println();
 	}
}
