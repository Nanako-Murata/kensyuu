package making.rpg.ch2;

public abstract class Character {
	// make a parent class
	// 多態性の練習
	String name;
	int hp;

	public void run() {
		System.out.println("run");

	}

	public abstract void attack(Mantango m);

}
