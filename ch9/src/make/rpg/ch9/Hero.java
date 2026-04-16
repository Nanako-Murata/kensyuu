package make.rpg.ch9;

//pattern for hero
public class Hero {
	String name;
	int hp;

	// Swordクラスからswordを作成
	// hero has a sword. has-a relationship between hero and sword
	Sword sword;

	// hero's name をargueする
	public Hero(String name) {
		this.name = name;
		this.hp = 50;
	}

	// hero の名前を空白にする場合を考慮
	// heroのHPの初期値を100に指定
	public Hero() {
		this.hp = 100;
		this.name = "ss";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
