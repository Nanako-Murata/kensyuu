package ch15;

//文字列切り出しメソッドを利用した例
public class Main15_3 {
	public static void main(String[] args) {
		String s1 = "Java programming";
		System.out.println("文字列s1の4文字目以降は" + s1.substring(3));
		System.out.println("文字列s1の4-8文字は" + s1.substring(3, 8));
	}

}
