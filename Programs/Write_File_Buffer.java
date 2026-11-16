import java.io.*;

class Write_File_Buffer {
	public static void main(String args[]) throws Exception {
		FileOutputStream ofile = new FileOutputStream("a1.txt");
		BufferedOutputStream b_file = new BufferedOutputStream(ofile);
		String s = "y = x^2";
		byte b[] = s.getBytes();
		
		b_file.write(b);
		System.out.println("Successfully wrote the file");
		b_file.close();
		ofile.close();
	}
}