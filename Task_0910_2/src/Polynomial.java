import java.util.ArrayList;

public class Polynomial {

	private ArrayList<Integer> coefArray = new ArrayList<Integer>();
	private ArrayList<Integer> expoAraay = new ArrayList<Integer>();

	public void insertArray(int coef, int expo) {
		coefArray.add(coef);
		expoAraay.add(expo);
	}

	public int getCoef(int index) {
		return coefArray.get(index);
	}

	public int getExpo(int index) {
		return expoAraay.get(index);
	}

	public int getSize() {
		return coefArray.size();
	}

	public void print() {

		for (int i = 0; i < coefArray.size(); i++) {
			int coef = coefArray.get(i);
			int expo = expoAraay.get(i);

			// X^0�� ���, �ڿ����� ����ϱ� ���� ó��
			String isDigit = expo == 0 ? "" : "X^" + expo;

			// ������ ������ ���ֱ� ���� ó��
			if (i == coefArray.size() - 1) {
				System.out.print(coef + isDigit);
				System.out.println();
			} else {
				if(coef==0) {
					continue;
				}
				System.out.print(coef + isDigit + " + ");
			}
		}
	}

}