package make.rpg;

/*
 * 練習問題
 * 聖職者をつくるクラス
 */
public class Cleric {
	String name;
	int hp = 50;
	int maxHp = 50;
	int mp = 10;
	int maxMp = 10;

	public void sefAid() {
		mp -= 5;
		hp = maxHp;

	}

	public void prey(int sec) {
		int mpIncr = sec + new java.util.Random().nextInt(3);
		int acMpIncr = Math.min(this.maxMp - this.mp, mpIncr);
		this.mp += acMpIncr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
