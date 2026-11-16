class Shape {
	String name;
}

class Square extends Shape {
	float side;
	Square (float side) {
		this.side = side;
		this.name = "Square";
	}
	void About() {
		System.out.println("Side of " + name + " is " + side);
		System.out.println("Area of " + name + " is " + side*side);
	}
}

class Cube extends Square {
	float side;
	Cube (float side) {
		super(side);
		this.name = "Cube";
	}
	void About() {
		System.out.println("Side of " + name + " is " + super.side);
		System.out.println("Surface Area of " + name + " is " + 6 * super.side * super.side);
		System.out.println("Volume of " + name + " is " + super.side * super.side * super.side);
	}
}

class Main6 {
	public static void main(String args[]) {
		Square square1 = new Square(10);
		square1.About();
		System.out.println();
		Cube cube1 = new Cube(10);
		cube1.About();
	}
}