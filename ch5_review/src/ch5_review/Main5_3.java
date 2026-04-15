package ch5_review;

//to call a method from another method
public class Main5_3 {
	public static void eat() {
		System.out.print("to eat ");
		bread();

	}

	public static void bread() {
		System.out.println("some slices of bread");
	}

	public static void main(String[] args) {
		eat();
	}

}
