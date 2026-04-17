package ch15;
//splitメソッドを使った文字列の分割
public class Main15_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc,def:ghi";
		String[] words = s.split("[,:]");
		for (String w : words) {
			System.out.print(w + "->");
		}

	}

}
