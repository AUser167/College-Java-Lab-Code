class Coordinate {
	int x;
	int y;
	
	Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void display() {
		System.out.println("(" + x + "," + y + ")");
	}
}

class Main4 {
	public static void main(String args[]) {
		Coordinate point1 = new Coordinate(10, 2);
		Coordinate point2 = new Coordinate(3, 2);
		point1.display();
		point2.display();
	}
}