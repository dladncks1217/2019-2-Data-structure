public class BucketSort {
	public static void sort(int[] a, int R) {
		int [] bucket = new int[R];
		for (int i=0; i<R; i++)  bucket[i]=0;  // 초기화
		for (int i=0; i< a.length; i++)  bucket[a[i]]++; // 1단계:빈도수 계산
		// 2단계: 순차적으로 버킷의 인덱스를 배열 a에 저장
		int j=0;  // j는 다음 저장될 배열 a 원소의 인덱스 
		for (int i=0; i<R; i++)   
			while((bucket[i]--)!=0)  //  버킷  i에 저장된 빈도수가 0이 될 때까지
				a[j++] = i;  // 버킷 인덱스 i를 저장
	}
	public static void main(String[] args) {
		int [] a = {2, 0, 5, 0, 3, 2,5, 2, 3, 1, 0, 2};
		sort(a, 10);
		System.out.print("정렬 결과: ");
		for (int i = 0; i < a.length; i++) {
			System.out.printf(a[i]+"  ");
		}
	}
}
