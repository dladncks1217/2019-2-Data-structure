public class main {
	public static void main(String[] args) {
		String a[] = {" ","H","E","A","P","S","O","R","T","E","X","A","M","P","L","E"};	
		Heap.sort(a);
		System.out.printf("정렬 결과: ");
		for (int i = 1; i < a.length; i++) {
			System.out.printf(a[i]+"  ");
		}
	}
}
