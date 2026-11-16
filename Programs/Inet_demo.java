import java.io.*;
import java.net.*;

class Inet_demo {
	public static void main(String args[]) {
		try {
			InetAddress IP = InetAddress.getByName("www.example.com");
			System.out.println(IP.getHostName());
			System.out.println(IP.getHostAddress());
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}