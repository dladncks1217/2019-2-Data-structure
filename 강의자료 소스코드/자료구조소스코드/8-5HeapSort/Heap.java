import java.lang.Comparable;
public class Heap {
	public static void sort(Comparable[] a) {
		int heapSize = a.length-1;           // a[0]는 사용 안함
		for (int i = heapSize/2; i > 0; i--) // 힙 만들기 
			downheap(a, i, heapSize);
		while (heapSize > 1) {        // 힙 정렬
			swap(a, 1, heapSize--);   // 현재 힙에서 가장 큰 값을 가진 a[1]과 힙의 마지막 원소와 교환
			downheap(a, 1, heapSize); // 위배된 힙 속성 고치기
		}
	}
	private static void downheap(Comparable[] a, int p, int heapSize) {
		while (2*p <= heapSize) {
			int s = 2*p;    //s=왼쪽 자식의 인덱스
			if (s < heapSize && isless(a[s], a[s+1])) s++; // 오른쪽 자식이 큰 경우
			if (!isless(a[p], a[s])) break; // 부모(p)가  자식 승자(s)보다 크면 힙 조건 만족
			swap(a, p, s);  // 힙 속성 만족 안하면  부모(p)와  자식 승자(s) 교환
			p = s;          // 이제 자식 승자의 자리에 부모가 있게됨
		}
	}
	private static boolean isless(Comparable i, Comparable j) {
		return (i.compareTo(j) < 0);
	}
    private static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
