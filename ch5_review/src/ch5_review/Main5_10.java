package ch5_review;

/*
 * handle overload with different-type arguments
 * argumentsを使うときはother methodsから出力される
 * 代入する値はmain method, 方程式はother methodに記入する
 */

public class Main5_10 {
	public static void main(String[] args) {
		calc(2, 5);
		calc(3.3, 4.4);

	}

	public static void calc(int a, int b) {
		System.out.println(a + b);
	}

	public static void calc(double a, double b) {
		System.out.println(a * b);
	}

}
