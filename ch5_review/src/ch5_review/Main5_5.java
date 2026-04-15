package ch5_review;

//handle some arguments
public class Main5_5 {
	public static void main(String[] args) {
		calc(2, 3);
		calc(10, 4);

	}

	public static void calc(int a, int b) {
		System.out.print("the total of " + a + " and " + b + " is ");
		System.out.print(a + b + ".");
		System.out.println();
	}
}