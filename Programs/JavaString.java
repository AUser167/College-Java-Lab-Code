import java.lang.String;

class JavaString {
	public static void main(String args[]) {
		String s1 = "CSE";
		String s2 = "CSE";
		String s3 = new String("CSE");
		String s4 = "Classes";
		
		System.out.println("String Comparison: ");
		System.out.println("s1.equals(s2) = " + s1.equals(s2));
		System.out.println("s2.equals(s3) = " + s2.equals(s3));
		System.out.println("s2.equals(s4) = " + s2.equals(s4));
		System.out.println();
		
		System.out.println("== operator: ");
		System.out.println("s1 == s2 gives " + (s1 == s2));
		System.out.println("s1 == s3 gives " + (s1 == s3));
		System.out.println();
		
		System.out.println("Compare To: ");
		System.out.println("s1.compareTo(s2) = " + s1.compareTo(s2));
		System.out.println("s1.compareTo(s3) = " + s1.compareTo(s3));
		System.out.println("s1.compareTo(s4) = " + s1.compareTo(s4));
		System.out.println("s4.compareTo(s1) = " + s4.compareTo(s1));
	}
}