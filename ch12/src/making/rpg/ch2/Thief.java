package making.rpg.ch2;

public class Thief extends Character{
	public void attack(Mantango m) {
		System.out.println(this.name + "の攻撃！");
		System.out.println(m.name + "に3ポイントのダメージ！");
		m.hp -= 3;
	}

}
