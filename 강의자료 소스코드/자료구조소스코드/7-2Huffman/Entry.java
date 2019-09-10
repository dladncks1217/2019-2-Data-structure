public class Entry {
	private int    frequency;  // 빈도 수
	private String word;       // 이파리 노드의 문자 또는 내부노드의 합성된 문자열 
	private Entry  left;       // 왼쪽 자식
	private Entry  right;      // 오른쪽 자식
	private String code;       // 허프만 코드
	
	public Entry (int newFreq, String newValue, Entry l, Entry r, String s){
		frequency = newFreq;
		word  = newValue;
		left  = l;
		right = r;
		code  = s;
	}
	public int    getKey()   { return frequency; }
	public String getValue() { return word; }
	public String getCode()  { return code; }
	public Entry  getLeft()  { return left; }
	public Entry  getRight() { return right; }

	public void   setCode(String newCode) { code = newCode; }
}
