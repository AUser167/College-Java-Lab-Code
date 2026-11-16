class JavaStringBasic {
	public static void main(String args[]) {
		String s = "CSE";
		System.out.println("s = " + s);
		s = s.concat("Dept");
		System.out.println("s.concat(\"Dept\") gives " + s);
		
		System.out.println("Upper Case of s = " + s.toUpperCase());
		System.out.println("Lower Case of s = " + s.toLowerCase());
		System.out.println("s starts with C = " + s.startsWith("C"));
		System.out.println("s ends with E = " + s.endsWith("E"));
		System.out.println("Char At 2 in s = " + s.charAt(2));
		System.out.println("Length of s = " + s.length());
		System.out.println("Replace E with B in s = " + s.replace("E", "B"));
	}
}