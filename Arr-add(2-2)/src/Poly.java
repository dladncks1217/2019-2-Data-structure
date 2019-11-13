import java.util.Scanner;

public class Poly {

   public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);

      System.out.println("--------다항식 A를 입력하겠습니다. --------");
      Polynomial A = new Polynomial();
      
      String a = sc.nextLine();
      String[] splitToPlusA = new String[0];
      String[] splitToExponentiationA = new String [0]; 
      splitToPlusA = a.split("\\+");
      for (int i=0;i<splitToPlusA.length;i++){
         if(splitToPlusA[i].length()>2) {
            splitToExponentiationA = splitToPlusA[i].split("x|\\^");
             int coef = Integer.parseInt(splitToExponentiationA[0]);
             int expo = Integer.parseInt(splitToExponentiationA[2]);
             A.insertArray(coef, expo);
         }
         else {
            if(splitToPlusA[i].equals("x")) {
               A.insertArray(1, 1);
            }
            else {
               if(splitToPlusA[i].length()==2) {
                  splitToExponentiationA = splitToPlusA[i].split("x");
                  int coef = Integer.parseInt(splitToExponentiationA[0]);
                  int expo = 1;
                  A.insertArray(coef, expo);
               }
               else {
                  int coef = Integer.parseInt(splitToPlusA[i]);
                  int expo = 0;
                  A.insertArray(coef, expo);
               }
            }
         }
      }

      System.out.print("->A결과: ");
      A.print();

      System.out.println("--------다항식 B를 입력하겠습니다. --------");
      Polynomial B = new Polynomial();

      // B식 입력
      String b = sc.nextLine();
      String[] splitToPlusB = new String[0];
      String[] splitToExponentiationB = new String [0]; 
      splitToPlusB = b.split("\\+");
      for (int i=0;i<splitToPlusB.length;i++){
         if(splitToPlusB[i].length()>2) {
            splitToExponentiationB = splitToPlusB[i].split("x|\\^");
             int expo = Integer.parseInt(splitToExponentiationB[2]);
             int coef = Integer.parseInt(splitToExponentiationB[0]);
             B.insertArray(coef, expo);
         }
         else {
            if(splitToPlusB[i].equals("x")) {
               B.insertArray(1, 1);
            }
            else {
               if(splitToPlusB[i].length()==2) {
                  splitToExponentiationB = splitToPlusB[i].split("x");
                  int coef = Integer.parseInt(splitToExponentiationB[0]);
                  int expo = 1;
                  B.insertArray(coef, expo);
               }
               else {
                  int coef = Integer.parseInt(splitToPlusB[i]);
                  int expo = 0;
                  B.insertArray(coef, expo);
               }
            }
         }
      }

      System.out.print("->B결과: ");
      B.print();

      Polynomial C = new Polynomial();

      int startA = 0;
      int finishA = A.getSize()-1;
      int startB = 0;
      int finishB = B.getSize()-1;

      while (startA <= finishA && startB <= finishB) {

         // A의 지수가 B의 지수보다 큰 경우
         if (A.getExpo(startA) > B.getExpo(startB)) {
            C.insertArray(A.getCoef(startA), A.getExpo(startA));
            startA++;
         }
         // B의 지수가 A의 지수보다 큰 경우
         else if (A.getExpo(startA) < B.getExpo(startB)) {
            C.insertArray(B.getCoef(startB), B.getExpo(startB));
            startB++;
         }
         // A의 지수와 B의 지수가 같은 경우
         else {
            C.insertArray(A.getCoef(startA) + B.getCoef(startB), A.getExpo(startA));
            startA++;
            startB++;
         }
      }

      // A에 항이 남아 있는 경우 C에 추가
      for (; startA <= finishA; startA++)
         C.insertArray(A.getCoef(startA), B.getExpo(startA));

      // B에 항이 남아 잇는 경우 B에 추가
      for (; startB <= finishB; startB++)
         C.insertArray(B.getCoef(startB), B.getExpo(startB));

      System.out.print("->A+B결과: ");
      C.print();

   }
}