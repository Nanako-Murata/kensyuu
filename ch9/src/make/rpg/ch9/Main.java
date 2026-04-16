package make.rpg.ch9;

//heroやswordを動かすmain methodを作成する
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//make a sword
		Sword s = new Sword();
		s.name = "勇者の剣";
		s.damage = 10;

		// make a hero kate
		Hero h1 = new Hero();
		h1.name = "Kate";
		h1.sword = s;

		// make a hero F
		Hero h3 = new Hero("F");

		// make a wizard
		Wizard w = new Wizard();
		w.name = "Wil";
		w.hp = 100;

		// output
		System.out.println(h1.hp);
		System.out.println(h3.hp);

	}

}
