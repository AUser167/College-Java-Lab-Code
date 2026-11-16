import java.io.*;
import java.net.*;

class Read_url {
	public static void main(String args[]) throws Exception {
		URL url1 = new URL("https://raw.githubusercontent.com/HimanshuBansal112/MCP-Notes-Maker/main/.gitignore");
		URLConnection url2 = url1.openConnection();
		InputStream IS = url2.getInputStream();
		int i;
		
		while ((i = IS.read()) != -1) {
			System.out.print((char) i);
		}
	}
}