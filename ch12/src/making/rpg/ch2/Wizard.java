package making.rpg.ch2;

//making a class
public class Wizard extends Character {
	int mp;

	public void attack(Mantango m) {
		System.out.println(this.name + "の攻撃！");
		System.out.println(m.name + "に3ポイントのダメージ！");
		m.hp -= 3;
	}

	public void fireball(Mantango m) {
		System.out.println(this.name + "は火の玉を打った！");
		System.out.println(m.name + "に20のダメージ");
		m.hp -= 20;
		this.mp -= 5;
	}

}
