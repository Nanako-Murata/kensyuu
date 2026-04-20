package ch17;

//練習問題17_1
public class Renshumondai {
	public static void main(String[] args) {
		try {
			String x = null;
			System.out.println(x.length());
		} catch (NullPointerException e) {
			System.out.println("NullPointerException occurs");
			System.out.println("stack trace stars here.");
			e.printStackTrace();
			System.out.println("stack trace ends here.");
		}

	}

}
