public class Node {
  int parent;  
  int rank;
  
  public Node(int newParent, int newRank){
	  parent = newParent;
	  rank   = newRank; 
  }
  
  public int getParent() {return parent;}
  public int getRank()   {return rank;}
  
  public void setParent(int newParent) {parent = newParent;}
  public void setRank(int newRank)     {rank   = newRank;}
}
