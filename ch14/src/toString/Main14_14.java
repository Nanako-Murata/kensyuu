package toString;

//newせずとも静的メソッドは呼び出し可能
public class Main14_14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hero.setRandomMoney();
		System.out.println(Hero.money);
		Hero h1 = new Hero();
		System.out.println(Hero.money);

	}

}
