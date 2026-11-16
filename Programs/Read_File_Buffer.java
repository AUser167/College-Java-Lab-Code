import java.io.*;

class Read_File_Buffer {
	public static void main(String args[]) throws Exception {
		FileInputStream infile = new FileInputStream("a1.txt");
		BufferedInputStream b_file = new BufferedInputStream(infile);
		int ch;
		
		while ((ch = b_file.read()) != -1) {
			System.out.print((char) ch);
		}
		
		b_file.close();
		infile.close();
	}
}