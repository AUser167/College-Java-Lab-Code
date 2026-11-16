import java.util.Scanner;

class Main3 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int number;
		String oper;
		double a,b;
		double result;
		System.out.println("This is a calculator.");
		
		while (true) {
			System.out.print("\nEnter first number: ");
			a = sc.nextDouble();
			
			System.out.print("Enter operator: ");
			oper = sc.next();
			
			System.out.print("Enter second number: ");
			b = sc.nextDouble();
			
			switch(oper) {
				case "+":
					result = a + b;
					break;
				case "-":
					result = a - b;
					break;
				case "*":
					result = a * b;
					break;
				case "/":
				case "\\":
					result = a / b;
					break;
				case "^":
				case "**":
					result = Math.pow(a, b);
					break;
				default:
					System.out.println("Invalid operator! Try again");
					continue;
			}
			System.out.println("Result of " + a + " " + oper + " " + b + " = " + result);
		}
	}
}