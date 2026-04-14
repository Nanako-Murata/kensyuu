package ch3;

/*
 * if else if else文の練習
 */
public class Main3_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("あなたの運勢を占います");
		int fortune = new java.util.Random().nextInt(5);
		if (fortune ==1) {
			System.out.println("大吉");
		}else if (fortune == 2) {
			System.out.println("中吉");
		}else if (fortune == 3) {
			System.out.println("吉");
		}else {
			System.out.println("凶");
		
		}

	}

}
