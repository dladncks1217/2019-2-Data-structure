import java.util.Scanner;

public class Task_0910_2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("--------다항식 A를 입력하겠습니다. --------");
		Polynomial A = new Polynomial();

		// A식 입력
		while (true)

		{
			System.out.print("계수: ");
			int coef = sc.nextInt();

			// -1입력시 종료
			if (coef == -1) {
				break;
			}
			System.out.print("지수: ");
			int expo = sc.nextInt();

			A.insertArray(coef, expo);

		}

		System.out.print("->A결과: ");
		A.print();

		System.out.println("--------다항식 B를 입력하겠습니다. --------");
		Polynomial B = new Polynomial();

		// B식 입력
		while (true)

		{
			System.out.print("계수: ");
			int coef = sc.nextInt();

			// -1입력시 종료
			if (coef == -1) {
				break;
			}
			System.out.print("지수: ");
			int expo = sc.nextInt();

			B.insertArray(coef, expo);

		}

		System.out.print("->B결과: ");
		B.print();

		Polynomial C = new Polynomial();

		int startA = 0;
		int finishA = A.getSize()-1;
		int startB = 0;
		int finishB = B.getSize()-1;

		while (startA <= finishA && startB <= finishB) {

			// A의 지수가 B의 지수보다 큰 경우
			if (A.getExpo(startA) > B.getExpo(startB)) {
				C.insertArray(A.getCoef(startA), A.getExpo(startA));
				startA++;
			}
			// B의 지수가 A의 지수보다 큰 경우
			else if (A.getExpo(startA) < B.getExpo(startB)) {
				C.insertArray(B.getCoef(startB), B.getExpo(startB));
				startB++;
			}
			// A의 지수와 B의 지수가 같은 경우
			else {
				C.insertArray(A.getCoef(startA) + B.getCoef(startB), A.getExpo(startA));
				startA++;
				startB++;
			}
		}

		// A에 항이 남아 있는 경우 C에 추가
		for (; startA <= finishA; startA++)
			C.insertArray(A.getCoef(startA), B.getExpo(startA));

		// B에 항이 남아 잇는 경우 B에 추가
		for (; startB <= finishB; startB++)
			C.insertArray(B.getCoef(startB), B.getExpo(startB));

		System.out.print("->A+B결과: ");
		C.print();

	}
}