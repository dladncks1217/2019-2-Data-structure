import java.util.Scanner;

class Number3{


	void Task1(int a) {
		if(a<=1) {
			System.out.println(a-1);
			return;
		}
		int []Arrayfor = new int[a];
		Arrayfor[0] = 0;
		Arrayfor[1] = 1;
		for(int i = 2;i<a;i++) {
			Arrayfor[i] = Arrayfor[i-1] + Arrayfor[i-2];
		}
		System.out.println("반복 이용입니다."+Arrayfor[a-1]);
	}
	int Task2(int a) {
		if(a<=2)
			return a-1;
		else 
			return Task2(a-1)+Task2(a-2);
	}
}
public class Task_0903_2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		Number3 num = new Number3();
		
		num.Task1(a);
		System.out.println("순환 이용입니다."+num.Task2(a));
	}

}
