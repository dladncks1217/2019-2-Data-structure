public class main {
	public static void main(String[] args) {
		String a[] = {"M","E","R","G","E","S","O","R","T","E","X","A","M","P","L","E"};
		Merge.sort(a);
		System.out.print("정렬 결과 : ");
		for (int i = 0; i < a.length; i++) {
			System.out.printf(a[i]+"  ");
		}
	}
}
