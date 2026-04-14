package ch3;

public class Main3_renshumondai3_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("【数あてゲーム】");
		int ans = new java.util.Random().nextInt(10);
		for (int i = 0; i < 5; i++) {
			System.out.println("0~9の数字を入力してください");
			int num = new java.util.Scanner(System.in).nextInt();
			if (num == ans) {
				System.out.println("あたり！");
				break;
			} else {
				System.out.println("はずれ");
			}

		}
		System.out.println("ゲームを終了します");
	}

}
