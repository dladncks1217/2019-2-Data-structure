public class main {
	public static void main(String[] args) {
	String a[] = {"S","H","E","L","L","S","O","R","T","E","X","A","M","P","L","E"};	
    Shell.sort(a);
	System.out.printf("정렬 결과:  ");
	for (int i = 0; i < a.length; i++) {
		System.out.printf(a[i]+"  ");
	}
   }
}
