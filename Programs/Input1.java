import java.io.*;

class Input1 {
	public static void main(String args[]) throws Exception {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		String input = br.readLine();
		System.out.println("Input is " + input);
	}
}