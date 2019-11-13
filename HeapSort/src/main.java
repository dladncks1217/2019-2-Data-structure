public class main {
	public static void main(String[] args) {

		String b[] = {" ","90","60","80","50","30","40","70","10","20"};

		Heap.sort(b);
		System.out.printf("정렬 결과: ");
		
		System.out.println("");
		for(int i = 1;i<b.length;i++) {
			System.out.print(b[i]+" ");
		}
	}
}
