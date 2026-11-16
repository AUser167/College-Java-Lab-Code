class Animal {
	float weight;
	String name;
	int age;
	
	void speak() {
		System.out.println("Unknown");
	}
}

class Bird extends Animal {
	Bird(float weight, String name, int age) {
		this.weight = weight;
		this.name = name;
		this.age = age;
	}
	
	void speak() {
		System.out.println(name + " sound is Chirp chirp");
	}
}

class Cat extends Animal {
	Cat(float weight, String name, int age) {
		this.weight = weight;
		this.name = name;
		this.age = age;
	}
	
	void speak() {
		System.out.println(name + " sound is Meow");
	}
}

class Main5 {
	public static void main(String args[]) {
		Bird bird1 = new Bird(5, "Sparrow", 2);
		bird1.speak();
		
		Cat cat1 = new Cat(8, "Persion", 3);
		cat1.speak();
	}
}