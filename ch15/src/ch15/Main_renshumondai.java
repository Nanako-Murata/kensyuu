package ch15;
//練習問題15
public class Main_renshumondai {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < 101; i++) {
			sb.append(i).append(",");

		}
		String s = sb.toString();
		String[] a = s.split(",");
	}

}
