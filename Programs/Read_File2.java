import java.io.*;

class Read_File2 {
	public static void main(String args[]) throws Exception {
		File infile = new File("a1.txt");
		FileReader fr_infile = null;
		fr_infile = new FileReader(infile);
		int ch;
		
		while ((ch = fr_infile.read()) != -1) {
			System.out.print((char) ch);
		}
		
		fr_infile.close();
	}
}