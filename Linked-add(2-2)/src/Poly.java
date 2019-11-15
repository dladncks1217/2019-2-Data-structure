import java.util.Scanner;

public class Poly {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 다항식 A 만들기
		System.out.println("--------다항식 A를 입력하겠습니다. --------");
		Polynomial A = new Polynomial();

		while (true) {

			
			System.out.print("계수: ");
			int coef = sc.nextInt();
			// -1입력시 종료
			if (coef == -1) {
				break;
			}
			System.out.print("지수: ");
			int expo = sc.nextInt();
			A.insertNode(coef, expo);

		}
		System.out.print("->A결과: ");
		A.print();

		// 다항식 B 만들기
		System.out.println("--------다항식 B를 입력하겠습니다. --------");
		Polynomial B = new Polynomial();

		while (true) {

			System.out.print("계수: ");
			int coef = sc.nextInt();
			// -1입력시 종료
			if (coef == -1) {
				break;
			}
			System.out.print("지수: ");
			int expo = sc.nextInt();
			B.insertNode(coef, expo);

		}

		System.out.print("->B결과: ");
		B.print();

		Polynomial C = AddPolynomial(A, B);

		System.out.print("->A+B결과: ");
		C.print();
	}

	static Polynomial AddPolynomial(Polynomial A, Polynomial B) {
		ListNode a = A.head;
		ListNode b = B.head;
		Polynomial C = new Polynomial();

		// A나 B 둘 중 하나가 모든 항에 대해 덧셈이 끝나는 경우 while 종료
		while (a != null && b != null) {
			// B의 지수가 A의 지수보다 큰 경우
			if (a.expo < b.expo) {
				C.insertNode(b.coef, b.expo);
				b = b.next;
			}
			// A의 지수가 B의 지수보다 큰 경우
			else if (a.expo > b.expo) {
				C.insertNode(a.coef, a.expo);
				a = a.next;
			}
			// A의 지수와 B의 지수가 같은 경우
			else {
				C.insertNode(a.coef + b.coef, a.expo);
				a = a.next;
				b = b.next;
			}
		}

		// A에 항이 남아 있는 경우 C에 추가
		while (a != null) {
			C.insertNode(a.coef, a.expo);
			a = a.next;
		}

		// B에 항이 남아 잇는 경우 B에 추가
		while (b != null) {
			C.insertNode(b.coef, b.expo);
			b = b.next;
		}

		return C;
	}
}
