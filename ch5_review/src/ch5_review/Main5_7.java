package ch5_review;

//handle a return value
//output the result from main method
public class Main5_7 {
	public static void main(String[] args) {
		String greet = ("hello, " + "Kate");
		System.out.println(greet);

	}

	public static String greeting(String sentence, String name) {
		String greet = sentence + name;
		return greet;

	}



}
/*
 * argumentの場合
 * main methodに代入したい値がある
 * other methodから出力される
 * return valueの場合
 * main methodに代入したい値がある
 * 方程式はother methodに記述する
 * main methodから出力される
 */
