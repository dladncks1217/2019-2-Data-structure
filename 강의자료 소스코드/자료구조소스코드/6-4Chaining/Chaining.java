public class Chaining<K, V> {
	 private int M = 11; // 테이블 크기
     private Node[] a = new Node[M]; // 해시 테이블
     public static class Node {  // Node 클래스
           private Object key;
           private Object data;
           private Node   next;
           public Node(Object newkey, Object newdata, Node ref){  // 생성자
        	   key  = newkey;
        	   data = newdata;
        	   next = ref;
           }
           public Object getKey()  { return key; }
           public Object getData() { return data;}
     }
     private int hash(K key) { //해시코드
    	 return (key.hashCode() & 0x7fffffff) % M; } // 나눗셈 연산

     public V get(K key) {  //탐색 연산
          int i = hash(key);
          for (Node x = a[i]; x != null; x = x.next)   // 연결리스트 탐색
                if (key.equals(x.key)) return (V) x.data;  // 탐색 성공
          return null;  // 탐색 실패
     }
     private void put(K key, V data) { // 삽입 연산
         int i = hash(key);
         for (Node x = a[i]; x != null; x = x.next)
               if (key.equals(x.key)) {  // 이미 key 존재
                     x.data =  data;     // 데이터만 갱신
                     return;
               }
         a[i] = new Node(key, data, a[i]); // 연결 리스트의 첫 노드로 삽입
    } 
     public static void main(String[] args) {
    	 Chaining t = new Chaining();
/*   	 //25, 37, 18, 55, 22, 35, 50, 63을 차례로 테이블에 저장
    	 t.put(25, "grape"); 	t.put(37, "apple");	t.put(18, "bananna");
    	 t.put(55, "cherry");	t.put(22, "mango");	t.put(35, "lime");
    	 t.put(50, "orange");	t.put(63, "watermelon");

    	 System.out.println("탐색 결과");
    	 System.out.println("50의 data = "+t.get(50));
    	 System.out.println("63의 data = "+t.get(63));
    	 System.out.println("37의 data = "+t.get(37));
    	 System.out.println("22의 data = "+t.get(22));
*/
    		t.put(71, "grape"); t.put(23, "apple");	t.put(73, "bananna");
    		t.put(49, "cherry");t.put(54, "mango");	t.put(89, "lime");
    		t.put(39, "orange");
    	 System.out.println();     	 System.out.println("해시 테이블");
    	 for(int i=0;i<t.M;++i) {
    		 System.out.print(String.format("%2d", i));
    		 Node x =t.a[i];
    		 while (x != null){
    			 System.out.print("-->["+x.getKey()+", "+x.getData()+"]");
    			 x = x.next;
    		 }
    		 System.out.println();
    	 }
     }
}
