package ch15;

//文字列調査メソッドを利用した例
public class Main15_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "スッキリJava";
		String s2 = "Java";
		String s3 = "java";
		if (s2.equals(s3)) {
			System.out.println("same");
		} else {
			System.out.println("different");
		}
		if (s2.equalsIgnoreCase(s3)) {
			System.out.println("大文字小文字を区別しなければ同じ");
		}
		System.out.println(s1.length());
		if (s1.isEmpty()) {
			System.out.println("Empty");
		} else {
			System.out.println("not empty");
		}

	}

}
