class Main8 {
	static void Divide(int a, int b) {
		try {
			System.out.println("Result of " + a + "/" + b + " is " + a/b);
		}
		catch (ArithmeticException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		finally {
			System.out.println("Always runs");
		}
	}
	
	public static void main(String args[]) {
		Divide(10,5);
		Divide(10,0);
	}
}