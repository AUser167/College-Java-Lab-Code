import java.util.Scanner;

class Main2_2 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int number;
		int i = 2; 
		System.out.print("Enter number to find out if prime number: ");
		number = sc.nextInt();
		
		if (number<=0) {
			System.out.println("Number is not prime");
			return;
		}
		
		while (i < Math.min(Math.sqrt(number) + 1, number)) {
			if (number%i==0) {
				System.out.println("Number is not prime");
				return;
			}
			i++;
		}
		
		System.out.println("Number is prime");
	}
}