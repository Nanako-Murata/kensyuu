package ch5_review;

/*
 * handle overload with defferent-quantity arguments
 * argumentsを使うときはsubmethodから出力
 * main methodに代入する値、submethodに方程式を記述する
 */
public class Main5_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		greeting("hello", "Dan", "Brown");
		greeting("I see you the first time for a year.", "Kate");

	}

	public static void greeting(String sentence, String first, String last) {
		System.out.println(sentence + " Mr. or Ms." + first + last);
	}

	public static void greeting(String sentence, String first) {
		System.out.println(sentence + first);
	}

}
