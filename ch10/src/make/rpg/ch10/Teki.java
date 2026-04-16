package make.rpg.ch10;

public class Teki {

	int hp = 50;
	char suffix;
	String name;

	public Teki(char suffix) {
		this.suffix = suffix;
	}

	public void attack(Hero h) {
		System.out.println("キノコ" + this.suffix + "の攻撃！");
		System.out.println(h.name + "に10のダメージ");
		h.hp -= 5;
	}

	public void run() {
		System.out.println("お化けキノコ" + this.suffix + "は逃げ出した！");

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
