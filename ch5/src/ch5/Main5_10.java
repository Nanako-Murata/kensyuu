package ch5;

//overload 引数の型が異なる場合
public class Main5_10 {
//1つめのadd method
	public static int add(int x, int y) {
		return x + y;

	}

	// 2つめのadd method
	public static double add(double x, double y) {
		return x + y;

	}

	// 3つめのadd method
	public static String add(String x, String y) {
		return x + y;

	}

	// ここからmain method
	public static void main(String[] args) {
		System.out.println(add(10, 20));
		System.out.println(add(1.1, 2.2));
		// 答えは3.3000000000000003になった。doubleでは正確な計算ができない
		System.out.println(add("hello", "world"));
	}

}
