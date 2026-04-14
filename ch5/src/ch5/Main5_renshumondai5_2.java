package ch5;

public class Main5_renshumondai5_2 {
	public static void main(String[] args) {
		email();

	}

	public static void email() {
		String title = "今日の日替わり弁当について";
		String address = "xxx@yyy.jp";
		String text = "今日の日替わり弁当は完売しました。";
		System.out.println(address + "に、以下のメールを送信しました。");
		System.out.println("件名：" + title);
		System.out.println("本文：" + text);

	}

}
