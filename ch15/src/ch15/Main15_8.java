package ch15;

//replaceAllメソッドを使った文字列の置換
//最初の文字だけ置換するreplaceFirst()の練習
public class Main15_8 {
	public static void main(String[] args) {
		String s1 = "abc, def, ghi";
		String w1 = s1.replaceAll("[def]", "X");
		String w2 = s1.replaceFirst("abc", "jjj");
		System.out.println(w1);
		System.out.println(w2);
	}

}
