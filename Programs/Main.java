import java.util.Scanner;

class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int age;
		System.out.print("Enter age: ");
		age = sc.nextInt();
		
		if (age<=0) {
			System.out.println("Invalid age");
		}
		else if (age<18) {
			System.out.println("You are not eligible");
		}
		else {
			System.out.println("You are eligible");
		}
	}
}