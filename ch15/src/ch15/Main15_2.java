package ch15;

//文字列検索メソッドを利用した例
public class Main15_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "Java and JavaScript";
		if (s1.contains("Java")) {
			System.out.println("it countains the word Java.");
		}
		if (s1.endsWith("Java")) {
			System.out.println("this ends with the word Java.");
		} else {
			System.out.println("this doesn't end with the word Java.");
		}
		System.out.println(s1.indexOf("Java"));
		System.out.println(s1.lastIndexOf("Java"));

	}

}
