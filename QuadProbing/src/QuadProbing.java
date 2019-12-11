public class QuadProbing<K, V>{
	private int M = 11;  // ���̺� ũ��
	private K[] a = (K[]) new Object[M]; // �ؽ����̺�
	private V[] d = (V[]) new Object[M]; // key���� ������ ����

	private int hash(K key){  // �ؽ��ڵ�
		return (key.hashCode() & 0x7fffffff) % M;  // ������ �Լ�
	}

	private void put(K key, V data) { // ���� ����
		int initialpos = hash(key);   // �ʱ� ��ġ
        int i = initialpos, j = 1;
        do {
            if (a[i] == null){  // ���� ��ġ �߰�
            	a[i]  = key;    // key�� �ؽ����̺� ����
            	d[i] = data;    // key���� �����͸� ������ �ε����Ͽ� ����
                  return;
            }
            if (a[i].equals(key)) {  // �̹� key ����
                d[i] = data;         // data�����͸� ����
            }            
            i = (initialpos + j * j++) % M; // i = ���� ��ġ           
        } while (i != initialpos);    
	}

	public V get(K key) {  // Ž�� ����
		int initialpos = hash(key);
        int i = initialpos, j = 1;
	        while (a[i] != null) {  // a[i]�� empty�� �ƴϸ�
	            if (a[i].equals(key))
	                return d[i];        // Ž�� ����
	            i = (initialpos + j * j++) % M; // i = ���� ��ġ
	        }            
	        return null; // Ž�� ����
	}

	public static void main(String[] args){ 

		QuadProbing t = new QuadProbing();
/*		//25, 37, 18, 55, 22, 35, 50, 63�� ���ʷ� ���̺� ����
		t.put(25, "grape"); 	t.put(37, "apple");	t.put(18, "bananna");
		t.put(55, "cherry");	t.put(22, "mango");	t.put(35, "lime");
		t.put(50, "orange");	t.put(63, "watermelone");
		
		System.out.println("Ž�� ���");
		System.out.println("50�� data = "+t.get(50));
		System.out.println("63�� data = "+t.get(63));
		System.out.println();
		*/
		t.put(71, "grape"); 
		for(int i=0;i<t.M;++i) System.out.printf("\t%2d",i);
		System.out.println();
		for(int i=0;i<t.M;++i) System.out.print("\t"+t.a[i]);
		System.out.println();
		System.out.println();
		
		t.put(23, "apple");	
		for(int i=0;i<t.M;++i) System.out.printf("\t%2d",i);
		System.out.println();
		for(int i=0;i<t.M;++i) System.out.print("\t"+t.a[i]);
		System.out.println();
		System.out.println();
		
		t.put(73, "bananna");
		for(int i=0;i<t.M;++i) System.out.printf("\t%2d",i);
		System.out.println();
		for(int i=0;i<t.M;++i) System.out.print("\t"+t.a[i]);
		System.out.println();
		System.out.println();
		
		t.put(49, "cherry");
		for(int i=0;i<t.M;++i) System.out.printf("\t%2d",i);
		System.out.println();
		for(int i=0;i<t.M;++i) System.out.print("\t"+t.a[i]);
		System.out.println();
		System.out.println();
		
		t.put(54, "mango");
		for(int i=0;i<t.M;++i) System.out.printf("\t%2d",i);
		System.out.println();
		for(int i=0;i<t.M;++i) System.out.print("\t"+t.a[i]);
		System.out.println();
		System.out.println();
		
		t.put(89, "lime");
		for(int i=0;i<t.M;++i) System.out.printf("\t%2d",i);
		System.out.println();
		for(int i=0;i<t.M;++i) System.out.print("\t"+t.a[i]);
		System.out.println();
		System.out.println();
		
		t.put(39, "orange");
		for(int i=0;i<t.M;++i) System.out.printf("\t%2d",i);
		System.out.println();
		for(int i=0;i<t.M;++i) System.out.print("\t"+t.a[i]);
		System.out.println();
		System.out.println();
		
		System.out.println("�ؽ� ���̺�");
		for(int i=0;i<t.M;++i) System.out.printf("\t%2d",i);
		System.out.println();
		for(int i=0;i<t.M;++i) System.out.print("\t"+t.a[i]);
		System.out.println();
		System.out.println();
	}
}
