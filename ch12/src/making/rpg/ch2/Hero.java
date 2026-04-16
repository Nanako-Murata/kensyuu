package making.rpg.ch2;

public class Hero extends Character{
	String name;
	public void attack(Mantango m) {
		System.out.println(this.name + "の攻撃！");
		System.out.println(m.name + "に3ポイントのダメージ！");
		m.hp -= 3;
	}

	

}
