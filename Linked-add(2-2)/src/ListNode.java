public class ListNode {
    int coef;
    int expo;
    ListNode next;
    
    public ListNode() {
        next = null;
    }
    
    public ListNode(int coef, int expo){
        this.coef = coef;
        this.expo = expo;
        this.next = null;
    }
    
    public ListNode(int coef, int expo, ListNode next){
        this.coef = coef;
        this.expo = expo;
        this.next = next;
    }
    
    public int getCoef() {
        return this.coef;
    }
    
    public int getExpo() {
        return this.expo;
    }
}