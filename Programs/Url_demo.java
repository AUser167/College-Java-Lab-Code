import java.net.*;

class Url_demo {
	public static void main(String args[]) throws Exception {
		URL url1 = new URL("https://example.com/index.html");
		System.out.println(url1.getProtocol());
		System.out.println(url1.getHost());
		System.out.println(url1.getPort());
		System.out.println(url1.getFile());
	}
}