public class Polynomial {
    ListNode head;
    
    public Polynomial() {
        head = null;
    }
    
    public void insertNode(int coef, int expo){
        ListNode node = new ListNode(coef, expo);
        if(head==null){
            head = node;
        }else{
            ListNode current = head;
            while(current.next!=null){
                current = current.next;
            }
            current.next = node;
        }
    }
    
    public void print(){
        if(head==null){
            System.out.println("출력할 노드가 존재하지 않습니다.");
        }else{
            ListNode current = head;

            while(current.next!=null){
            	String isDigit = current.expo == 0?"":"X^"+current.expo ;
                System.out.print(current.coef + isDigit+ " + ");
                current = current.next;
            }
        	String isDigit = current.expo == 0?"":"X^"+current.expo ;
            System.out.print(current.coef + isDigit);
            System.out.println();
        }
    }
}








