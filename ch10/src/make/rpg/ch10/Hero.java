package make.rpg.ch10;

public class Hero {

	/*
	 * pattern of normal heroF
	 * 継承元の作成
	*/

		String name = "Ito";
		int hp = 100;

		// fight
		public void fight(Teki t) {
			System.out.println(this.name + "の攻撃！");
			t.hp -= 5;
			System.out.println("5ポイントのダメージを与えた");

		}

		// run away
		public void run() {
			System.out.println(this.name + "は逃げ出した");
		}

	}

