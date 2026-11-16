package Package1;

public class Four_nums {
	int num1;
	public int num2;
	private int num3;
	protected int num4;
	
	public Four_nums(int num1, int num2, int num3, int num4) {
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
		this.num4 = num4;
	}
	
	public void Print_Sum() {
		System.out.println(num1 + num2 + num3 + num4);
	}
}