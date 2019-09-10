public class LinearProbing<K, V> {
	private int M = 11;  // 테이블 크기
	private K[] a = (K[]) new Object[M]; // 해시테이블
	private V[] d = (V[]) new Object[M]; // key관련 데이터 저장
	private int hash(K key){ // 해시코드
		return (key.hashCode() & 0x7fffffff) % M;  // 나눗셈 함수
	}
	private void put(K key, V data) {  // 삽입 연산
		int initialpos = hash(key);    // 초기 위치 
		int i = initialpos, j = 1;
		do {
			if (a[i] == null){  // 삽입 위치 발견
				a[i] = key;     // key를 해시테이블에 저장
				d[i] = data;    // key관련 데이터를 동일한 인덱스하에 저장 
				return;
			}
			if (a[i].equals(key)) {  // 이미 key 존재
				d[i] = data;    // 데이터만 갱신
				return; 
			}            
			i = (initialpos + j++) % M; // i = 다음 위치           
		} while (i != initialpos); // 현재 i가 초기위치와 같게되면 루프 종료   
	}
	public V get(K key) {  // 탐색 연산
		int initialpos = hash(key);
		int i = initialpos, j = 1;
		while (a[i] != null) {  // a[i]가 empty가 아니면
			if (a[i].equals(key))
				return d[i];    // 탐색 성공
			i = (initialpos + j++) % M; // i = 다음 위치
		}            
		return null; // 탐색 실패
	}
	public static void main(String[] args){ 
		LinearProbing t = new LinearProbing();
/*		//25, 37, 18, 55, 22, 35, 50, 63을 차례로 해시테이블에 저장
		t.put(25, "grape"); t.put(37, "apple");	t.put(18, "bananna");
		t.put(55, "cherry");t.put(22, "mango");	t.put(35, "lime");
		t.put(50, "orange");t.put(63, "watermelon");
		
		System.out.println("탐색 결과:");
		System.out.println("50의 data = "+t.get(50));
		System.out.println("63의 data = "+t.get(63));
		System.out.println();
*/
		t.put(71, "grape"); t.put(23, "apple");	t.put(73, "bananna");
		t.put(49, "cherry");t.put(54, "mango");	t.put(89, "lime");
		t.put(39, "orange");
		
		System.out.println("해시 테이블:");   
		for(int i=0;i<t.M;++i) System.out.printf("\t%2d",i);
		System.out.println();
		for(int i=0;i<t.M;++i) System.out.print("\t"+t.a[i]);
		System.out.println();
	}
}
