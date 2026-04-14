package ch3;

//あえてbreak文を書かない
public class Main3_6 {
	public static void main(String args) {
		System.out.println("今日のあなたの運勢は、、、");
		int fortune = new java.util.Random().nextInt(4) + 1;
		switch (fortune) {
		case 1:
		case 2:
			System.out.println("いいね");
			break;
		case 3:
		case 4:
			System.out.println("まあまあ");
			break;
		case 5:
			System.out.println("事故にあうでしょう");

		}
	}

}
