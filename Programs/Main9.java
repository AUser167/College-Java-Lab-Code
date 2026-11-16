class Main9 {
	static void Divide(int index1, int index2) {
		int[] nums = new int[] { 0,1,2,3,4,5 };
		try {
			System.out.println("Result of " + nums[index1] + "/" + nums[index2] + " is " + nums[index1]/nums[index2]);
		}
		catch (ArithmeticException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println("Unexpected Error: " + e);
		}
	}
	
	public static void main(String args[]) {
		Divide(4,2);
		Divide(1,0);
		Divide(1,10);
	}
}