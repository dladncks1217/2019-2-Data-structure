public class main {
	public static void main(String[] args) {

		SList<String> s = new SList<String>();  // 연결 리스트 객체 s 생성
        s.insertFront("orange"); s.insertFront("apple");
		s.insertAfter("cherry",s.head.getNext()); 
		s.insertFront("pear"); 			
		s.print();
		System.out.println(": s의 길이 = "+s.size()+"\n"); 
		System.out.println("체리가 \t"+s.search("cherry")+"번째에 있다.");
		System.out.println("키위가 \t"+s.search("kiwi")+"번째에 있다.\n");
		s.deleteAfter(s.head);
		s.print(); 
		System.out.println(": s의 길이 = "+s.size());System.out.println();
		s.deleteFront();
		s.print(); 
		System.out.println(": s의 길이 = "+s.size());System.out.println();
		
		SList<Integer> t = new SList<Integer>();  // 연결 리스트 객체 t 생성
		t.insertFront(500); t.insertFront(200);	
		t.insertAfter(400,t.head); 
		t.insertFront(100); 
		t.insertAfter(300,t.head.getNext()); 
		t.print();
		System.out.println(": t의 길이  = "+t.size());
		SList<Integer> x = new SList<Integer>();  // 연결 리스트 객체 t 생성
		x.insertFront(550); x.insertFront(375);	
		x.insertFront(350); x.insertFront(175);	x.insertFront(150);
		x.print();
		System.out.println(": x의 길이  = "+x.size()); System.out.println("-----------------------");
		SList<Integer> m = new SList<Integer>();
		m.setHead(m.mergeTwoLists(t.getHead(),x.getHead()));
		m.print();

		m.setHead(m.reverseList(m.getHead()));
		System.out.println("역방향 리스트: ");
		m.print();   System.out.println("-----------------------");

		SList<Integer> y = new SList<Integer>();  // 연결 리스트 객체 y 생성
		y.insertFront(450); y.insertFront(175);		y.insertFront(200); y.insertFront(50); y.insertFront(575);	y.insertFront(600);
		y.insertFront(350);y.insertFront(101); y.insertFront(575);	y.insertFront(150); y.insertFront(900);y.insertFront(10); y.insertFront(30);y.insertFront(70);
		y.print();
		System.out.println("중간 노드의 값 = "+y.findMiddleNode(y.getHead()).getItem());  System.out.println("-----------------------");

		SList<Integer> l1 = new SList<Integer>(); 
		SList<Integer> l2 = new SList<Integer>(); 
		y.splitList(y.getHead(),200, l1, l2);
		System.out.println("200을 기준으로 두 개의 리스트로 분리: ");
		l1.print(); 
		l2.print(); System.out.println("-----------------------");
		
		SList<Integer> w = new SList<Integer>();  // 연결 리스트 객체 w 생성
		w.insertFront(900); w.insertFront(800);		w.insertFront(600); w.insertFront(540); w.insertFront(530);	w.insertFront(500);
		w.insertFront(400);w.insertFront(330); w.insertFront(310);	w.insertFront(220); w.insertFront(100);w.insertFront(50);
		w.print();
		SList<Integer> u = new SList<Integer>();  // 연결 리스트 객체 u 생성
		u.insertFront(600); u.insertFront(550);		u.insertFront(500); u.insertFront(450); u.insertFront(400);	u.insertFront(350);
		u.insertFront(300);u.insertFront(250); u.insertFront(200);	u.insertFront(150); u.insertFront(100);
		u.print();
		System.out.println("공통 원소 합="+u.commonSum(w));  System.out.println("-----------------------");
		
		System.out.println("싸이클:"+w.cycleDetector());
		w.createCycle();
		System.out.println("싸이클:"+w.cycleDetector());
		

		
		
	}
}