package ch5;

public class Main5_renshumondai5_3 {
	public static void main(String[] args) {
		String address = "xxx@yyy.jp";
		String title = "今度飲みに行きませんか";
		String text = "今週末の日曜に飲みに行きましょう";
		email(address, title, text);
	}

	public static void email(String address, String title, String text) {
		System.out.println(address + "にメールを送信しました。");
		System.out.println("件名：" + title);
		System.out.println("本文:" + text);
	}

}
