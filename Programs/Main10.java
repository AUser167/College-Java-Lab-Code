class Main10 {
	static void Divide(int index1, int index2) throws Exception {
		int[] nums = new int[] { 0,1,2,3,4,5 };
		if (index1 > nums.length-1 || index2 > nums.length-1) {
			throw new Exception("Index out of range");
		}
		
		if (nums[index1] == 0 || nums[index2] == 0) {
			throw new Exception("Value equal to 0");
		}
		
		System.out.println("Result of " + nums[index1] + "/" + nums[index2] + " is " + nums[index1]/nums[index2]);
	}
	
	public static void main(String args[]) {
		try {
			Divide(4,2);
			Divide(1,0);
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}