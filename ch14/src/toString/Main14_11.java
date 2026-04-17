package toString;
//各インスタンスから静的フィールドを利用可能
//静的フィールドは複数のインスタントで書き換え可能　上書きされる
public class Main14_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hero h1 = new Hero();
		Hero h2 = new Hero();
		h1.money = 190;
		h2.money =200;
		System.out.println(h1.money);
		System.out.println(h2.money);

	}

}
