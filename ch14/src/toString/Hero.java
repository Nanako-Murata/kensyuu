package toString;

public class Hero {
	String name;
	int hp;
	static int money;

	public static void setRandomMoney() {
		Hero.money = (int) (Math.random() * 1000);
		System.out.println("所持金を初期化しました");

	}

}
