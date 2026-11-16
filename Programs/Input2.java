import java.io.*;

class Input2 {
	public static void main(String args[]) {
		Console c = System.console();
		String str = c.readLine();
		char[] password = c.readPassword();
		String password_str = new String(password);
		
		System.out.println("First input is " + str);
		System.out.println("Second input (password) is " + password_str);
	}
}