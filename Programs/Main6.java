interface IAnimal {
	void eat();
}

interface ICommercial {
	String owner = "Himanshu";
	void sell(int price);
}

class Pig implements IAnimal, ICommercial {
	public void eat() {
		System.out.println("Pig is eating");
	}
	public void sell(int price) {
		System.out.println(owner + " has sold the pig for " + price + " rupees");
	}
}

class Main6 {
	public static void main(String args[]) {
		Pig pig1 = new Pig();
		pig1.eat();
		pig1.sell(1000);
	}
}