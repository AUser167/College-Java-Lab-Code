import java.io.*;

class Write_File {
	public static void main(String args[]) {
		FileOutputStream ofile = null;
		byte b1[] = { 'y', '=', 'x', '^', '2' };
		try {
			ofile = new FileOutputStream("a1.txt");
			ofile.write(b1);
			ofile.close();
			System.out.println("Successfully wrote the file");
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}