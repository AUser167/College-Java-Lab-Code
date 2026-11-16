import java.io.*;

class Write_File2 {
	public static void main(String args[]) throws Exception {
		File outfile = new File("a1.txt");
		FileWriter ofile = null;
		ofile = new FileWriter(outfile);
		String s = "y = x^2";
		ofile.write(s);
		System.out.println("Successfully wrote the file");
		ofile.close();
	}
}