public class LSDsort {
	public static void sort(int[] a) {
		int R = 10;
		int N = a.length;
		int[] t = new int[N];
		for (int k = 10; k <= 1000; k*=10) {   
			int[] startIndex = new int[R+1];
			for (int i = 0; i < N; i++)    //빈도수 계산
				startIndex[(a[i]%k)/(k/10) + 1]++;  // (a[i]%k)/(k/10)은 a[i]의 각 자릿수를 추출
			for (int r = 0; r < R; r++)   // 각 버킷 인덱스 값이 저장될 배열 t의 시작 인덱스 계산
				startIndex[r+1] += startIndex[r];
			for (int i = 0; i < N; i++)   // 해당 버킷의 인덱스 값에 대응되는 a[i]를 배열 t에 차례로 저장
				t[startIndex[(a[i]%k)/(k/10)]++] = a[i];
			for (int i = 0; i < N; i++)   // 배열t를 배열 a로 복사
				a[i] = t[i];
			System.out.println();
			System.out.println(+k/10+"의 자리 정렬 결과:");
			for (int i = 0; i < N; i++)
				System.out.print(String.format("%03d", a[i]) + " ");
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int [] a = {251,430,301,540,551,401,2,10,124,22,204,115,901,804,666,789,920,911, 932, 743,855, 888,900,999,670,602,509,850,842,909, 395, 004, 382, 006, 010, 777,380, 350, 250,401,322 };
		System.out.println("정렬 전:");
		for(int i=0;i<a.length;++i) System.out.print(String.format("%03d", a[i]) + " ");
		System.out.println();
		sort(a);
		for(int i=0;i<a.length-1;++i) 
			if(a[i]>a[i+1]) System.out.println("Not Sorted");
	}
}
 