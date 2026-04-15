package make.rpg;

public class Main {
//すべてのクラスに対して指示を出すmethod
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Hero h = new Hero();
		// 敵を2体生成
		Teki t1 = new Teki();
		t1.hp = 50;
		t1.suffix = 'A';
		Teki t2 = new Teki();
		t2.hp = 48;
		t2.suffix = 'B';

		// 勇者を生成
		// フィールドに初期値を設定
		h.name = "Ken";
		h.hp = 100;
		System.out.println("勇者" + h.name + "を生み出しました！");
		// 勇者のメソッド=行動を呼び出す
		h.sit(5);
		h.slip();
		h.sit(25);
		h.run();

	}

}
