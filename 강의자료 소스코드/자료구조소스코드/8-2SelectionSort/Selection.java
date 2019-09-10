import java.lang.Comparable;
public class Selection {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {  // min 찾기
                if (isless(a[j], a[min])) min = j;
            }
            swap(a, i, min); // min과 a[i]의 교환
        }
    }
     private static boolean isless(Comparable i, Comparable j) { // 키 비교
        return (i.compareTo(j) < 0);
    }
    private static void swap(Comparable[] a, int i, int j) {    // 원소 교환
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
