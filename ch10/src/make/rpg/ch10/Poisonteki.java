package make.rpg.ch10;

public class Poisonteki extends Teki {
	int remainPoison = 5;

	public Poisonteki(char suffix) {
		super(suffix);

	}

	public void attack(Hero h) {
		super.attack(h);
		if (this.remainPoison > 0) {
			System.out.println(this.suffix + "は有機水銀毒を放出！！");
			System.out.println("勇者は水銀中毒を起こした！");
			int damage = h.hp / 5;
			h.hp -= damage;
			System.out.println("勇者は" + damage + "ポイントのダメージを受けた！");

		}
	}

}
