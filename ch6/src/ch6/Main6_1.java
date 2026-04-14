package ch6;

//計算機プログラム
public class Main6_1 {
	public static void main(String[] args) {
		int a = 10;
		int b = 5;
		int sigma = tasu(a, b);
		int delta = hiku(a, b);
		System.out.println("足すと" + sigma + ", 引くと" + delta);

	}

	public static int tasu(int a, int b) {
		int ans = a + b;
		return ans;

	}

	public static int hiku(int a, int b) {
		return (a - b);
	}

}
