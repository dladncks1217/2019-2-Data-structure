
public class Task_0903_3 {
	    static int count = 0;
	static void move(int n,char from, char to, char tmp, int counts) {
		
		
		if(n==1) {
			System.out.println(count+"��°"+n+"�̵�:"+ from + "->"+to);
		}else {
			move(n-1,from,tmp,to,count);
			System.out.println(count+"��°"+n+"�̵�:"+from+"->"+to);
			move(n-1,tmp,to,from,count);
		}
		count++;
		counts = count; 
	}
	public static void main(String[] args) {
		move(3,'A','B','C',count);

	}

}
