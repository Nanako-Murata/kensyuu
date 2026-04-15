package ch5_review;

//handle one argument
public class Main5_4 {
	public static void main(String[] args) {
		System.out.println("call methods");
		eat("chocolate");
		eat("rice");
		eat("soup");
		System.out.println("End");
	}

	public static void eat(String food) {
		System.out.println("eat " + food);
	}

}
