import java.io.*;

class Read_File {
	public static void main(String args[]) {
		FileInputStream infile = null;
		int b;
		try {
			infile = new FileInputStream("a1.txt");
			while ((b = infile.read()) != -1) {
				System.out.print((char) b);
			}
			infile.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}