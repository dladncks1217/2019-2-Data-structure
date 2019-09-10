public class main {
	public static void main(String[] args) {
		String a[] = {"I","N","S","E","R","T","I","O","N","S","O","R","T"};
		Insertion.sort(a);
		System.out.printf("정렬 결과:  ");
		for (int i = 0; i < a.length; i++) {
			System.out.printf(a[i]+"  ");
		}
	}
}
