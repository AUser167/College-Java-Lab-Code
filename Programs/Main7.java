import java.util.Scanner;

abstract class Person {
	String name;
	String father_name;
	String mother_name;
	int age;
	
	abstract void input();
	abstract void display();
}

class Student extends Person {
	String roll_no;
	String course_name;
	
	void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Roll No.: ");
		roll_no = sc.nextLine();
		System.out.print("Enter Student Name: ");
		name = sc.nextLine();
		System.out.print("Enter Father Name: ");
		father_name = sc.nextLine();
		System.out.print("Enter Mother Name: ");
		mother_name = sc.nextLine();
		System.out.print("Enter age: ");
		age = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter Course: ");
		course_name = sc.nextLine();
	}
	
	void display() {
		System.out.println("Roll No. is " + roll_no);
		System.out.println("Student Name is " + name);
		System.out.println("Father Name is " + father_name);
		System.out.println("Mother Name is " + mother_name);
		System.out.println("Age is " + age);
		System.out.println("Course is " + course_name);
	}
}

class Main7 {
	public static void main(String args[]) {
		Student student1 = new Student();
		student1.input();
		System.out.println();
		student1.display();
	}
}