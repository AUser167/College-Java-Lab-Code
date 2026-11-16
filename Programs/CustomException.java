class Ex1 extends Exception {
	Ex1(String s) {
		super(s);
		System.out.println("Custom exception ran");
	}
}

class CustomException {
	static void valid(int i) throws Ex1 {
		if (i<18) {
			throw new Ex1("Age should not be less than 18");
		}
	}
	public static void main(String args[]) {
		try {
			valid(16);
		}
		catch (Ex1 e) {
			System.out.println(e);
		}
	}
}