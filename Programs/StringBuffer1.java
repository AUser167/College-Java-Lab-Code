class StringBuffer1 {
	public static void main(String args[]) {
		StringBuffer sb = new StringBuffer("CSE");
		sb.append(" Classes");
		System.out.println("On appending \" Classes\" to \"CSE\" gives " + sb);
		System.out.println();
		
		sb.insert(1, "Java");
		System.out.println("sb.insert(1, \"Java\") gives:\n" + sb);
		System.out.println();
		
		sb.replace(0, 5, "Classes C");
		System.out.println("sb.replace(0, 5, \"Classes C\") gives:\n" + sb);
		System.out.println();
		
		sb.delete(0,8);
		System.out.println("sb.delete(0,8) gives:\n" + sb);
		System.out.println();
		
		sb.reverse();
		System.out.println("sb.reverse() gives:\n" + sb);
	}
}