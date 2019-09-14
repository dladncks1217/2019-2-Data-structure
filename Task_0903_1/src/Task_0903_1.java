import java.util.Scanner;
class Number2{
	private int i;
	private int result1 = 0;
	private int result2 = 0;
	private int result2_2 = 0;
	
	Number2(int i){
		this.i = i;
	}
	void number2_1(int a) {
		long start = System.currentTimeMillis();
		for(int k = 0;k<a;k++) {
			result1 += a;
		}
		long end = System.currentTimeMillis();
		System.out.println("1번문제 답 "+result1);
		System.out.println( "실행 시간 : " + ( end - start )/1000.0 );
		
	}
	void number2_2(int a) {
		long start = System.currentTimeMillis();
		for(int j = 0;j<a;j++) {
			result2 +=1;
		} 
		result2_2 = result2;
		for(int k = 0;k<result2_2;k++) {
			result2+=result2_2;
		}
		long end = System.currentTimeMillis();
		System.out.println("2번문제 답 "+result2);
		System.out.println( "실행 시간 : " + ( end - start )/1000.0 );
	}
}
public class Task_0903_1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		Number2 num = new Number2(a);
		num.number2_1(a);
		num.number2_2(a);
		}
}