import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;




class PostFixConverter {
   private String infix;
   private Stack<Character> stack = new Stack<Character>();
   private List<String> postfix = new ArrayList<String>();

   public PostFixConverter(String expression) {
      infix = expression;
      convertExpression();
   }

   private void convertExpression() {
      StringBuilder temp = new StringBuilder();

      for (int i = 0; i != infix.length(); ++i) {
         if (Character.isDigit(infix.charAt(i))) {
            temp.append(infix.charAt(i));

            while ((i + 1) != infix.length()
                  && (Character.isDigit(infix.charAt(i + 1)) || infix.charAt(i + 1) == '.')) {
               temp.append(infix.charAt(++i));
            }

            postfix.add(temp.toString());
            temp.delete(0, temp.length());
         }

         else
            inputToStack(infix.charAt(i));
      }
      clearStack();
   }

   private void inputToStack(char input) {
      if (stack.isEmpty() || input == '(')
         stack.push(input);
      else {
         if (input == ')') {
            while (!stack.peek().equals('(')) {
               postfix.add(stack.pop().toString());
            }
            stack.pop();
         } else {
            if (stack.peek().equals('('))
               stack.push(input);
            else {
               while (!stack.isEmpty() && !stack.peek().equals('(')
                     && getPrecedence(input) <= getPrecedence(stack.peek())) {
                  postfix.add(stack.pop().toString());
               }
               stack.push(input);
            }
         }
      }
   }

   private int getPrecedence(char op) {
      if (op == '+' || op == '-')
         return 1;
      else if (op == '*' || op == '/')
         return 2;
      else if (op == '^')
         return 3;
      else
         return 0;
   }

   private void clearStack() {
      while (!stack.isEmpty()) {
         postfix.add(stack.pop().toString());
      }
   }

   public void printExpression() {
      for (String str : postfix) {
         System.out.print(str + ' ');
      }
   }

   public List<String> getPostfixAsList() {
      return postfix;
   }
}

class PostFixCalculator {
   private List<String> expression = new ArrayList<String>();
   private Stack<Double> stack = new Stack<Double>();

   public PostFixCalculator(List<String> postfix) {
      expression = postfix;
   }

   public double result() {
      for (int i = 0; i != expression.size(); ++i) {
         // Determine if current element is digit or not
         if (Character.isDigit(expression.get(i).charAt(0))) {
            stack.push(Double.parseDouble(expression.get(i)));
         } else {
            double tempResult = 0;
            double temp;

            switch (expression.get(i)) {
            case "+":
               temp = stack.pop();
               tempResult = stack.pop() + temp;
               break;

            case "-":
               temp = stack.pop();
               tempResult = stack.pop() - temp;
               break;

            case "*":
               temp = stack.pop();
               tempResult = stack.pop() * temp;
               break;

            case "/":
               temp = stack.pop();
               tempResult = stack.pop() / temp;
               break;
            }
            stack.push(tempResult);
         }
      }
      return stack.pop();
   }
}

public class ConsoleCalc {

   public static void main(String[] args) throws IOException {
      String expression;
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      System.out.print("Enter expression: ");
      expression = br.readLine();

      PostFixConverter pc = new PostFixConverter(expression);
      System.out.print("Postfix: ");
      pc.printExpression();

      PostFixCalculator calc = new PostFixCalculator(pc.getPostfixAsList());
      System.out.println();
      System.out.println("Result: " + calc.result());
   }
}