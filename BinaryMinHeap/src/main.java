public class main {
	public static void main(String[] args)	{
		Entry[] a = new Entry[16];     // a[0]�� ��� ����  
		a[1]  = new Entry(10, "watermelon");a[2]  = new Entry(50, "pear");  	    
		a[3]  = new Entry(20, "melon");   	a[4]  = new Entry(60, "lime");  		
		a[5]  = new Entry(30, "mango");   	a[6]  = new Entry(70, "cherry");  	    
		a[7]  = new Entry(40, "grape");   	a[8]  = new Entry(80, "orange");  
		BHeap h = new BHeap(a,8);    // �� ��ü ����
		System.out.println("�� ����� ��:"); h.print();
		h.createHeap();  // �� �����
		System.out.println("�ּ���:"); h.print();
		System.out.println("min ���� ��"); System.out.println(h.deleteMin().getValue());
		h.print();
		h.insert(5,"apple"); System.out.println("5 ���� ��"); h.print();
		
	}
}
