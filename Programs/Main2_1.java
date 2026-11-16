import java.util.Scanner;

class Main2_1 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int number;
		System.out.print("Enter number to find out if prime number: ");
		number = sc.nextInt();
		
		if (number<=0) {
			System.out.println("Number is not prime");
			return;
		}
		
		for (int i = 2; i < Math.min(Math.sqrt(number) + 1, number); i++) {
			if (number%i==0) {
				System.out.println("Number is not prime");
				return;
			}
		}
		
		System.out.println("Number is prime");
	}
}