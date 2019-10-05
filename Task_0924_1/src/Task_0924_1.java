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
		} //숫자끼리 붙임
		
		postfix.add(temp.toString());
			temp.delete(0, temp.length());
	}
	
	else
	inputToStack(infix.charAt(i)); //연산기호면 스택에 저장
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
			while ((!stack.isEmpty() && !stack.peek().equals('('))
			&& outPrec(input) <= inPrec(stack.peek())) {
				postfix.add(stack.pop().toString());
			}
				stack.push(input);
			}
		}
	}
}

static int inPrec(char input) {
switch (input) {
	case '+':
	case '-':
	return 2;
	case '*':
	case '/':
	return 4;
	case '^':
	return 5;
	}
	return 0;
}

static int outPrec(char input) {
switch (input) {
	case '+':
	case '-':
	return 1;
	case '*':
	case '/':
	return 3;
	case '^':
	return 6;
	}
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
		case "^":
		temp = stack.pop();
		tempResult = Math.pow(stack.pop(), temp);
		break;
		}
		stack.push(tempResult);
	}
}
		return stack.pop();
		}
}

public class Task_0924_1 {

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