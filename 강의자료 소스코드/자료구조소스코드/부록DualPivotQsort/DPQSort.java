public class DPQSort {
	public void sort (int[] a){
		sort (a, 0, a.length-1);
	}
	private void sort(int[] a, int low, int high) {
		if (high <= low) return; 	
		int p1 = a[low];
		int p2 = a[high];	      
		if (p1 > p2){  // p1 < p2가 되도록
			swap(a, low, high);
			p1 = a[low];
			p2 = a[high];
		}
		// a[low]에 작은 비벗, a[high]에 큰 피벗
		// a[low+1]부터 a[lt-1]까지는 작은 피벗보다 작고 
		// a[gt+1]부터 a[high-1]까지는 큰 피벗보다 크다 
		int i  = low+1;   // 현재원소는 a[i]
		int lt = low+1;    
		int gt = high-1;  
		while (i <= gt){
			if (a[i] < p1)      swap(a, i++, lt++);
			else if (p2 < a[i]) swap(a, i,   gt--);
			else       			i++;
			System.out.print("i="+i +", lt ="+lt+", gt ="+gt+" >> ");
			for(int l = 0; l < a.length; l++)
				System.out.print(a[l] + " ");			
			System.out.println();
		}
		swap(a, low,  --lt);
		swap(a, high, ++gt);
	
		for(int l = 0; l < a.length; l++)
			System.out.print(a[l] + " ");			
		System.out.println();
		
		// 3 부분을 각각 재귀호출
		sort(a, low,  lt-1);
		sort(a, lt+1, gt-1);
		sort(a, gt+1, high);
	}
	
	private void swap(int[] a, int u, int v) {		
		int temp = a[u];
		    a[u] = a[v];
		    a[v] = temp;		
	}
}

