package make.rpg.ch9;

//pattern of wizard
//argumentを受け取る
public class Wizard {
	String name;
	int hp;

	public void heal(Hero h) {
		h.hp += 10;
		System.out.println(name + "は" + h.name + "のHPを10回復した！");
	}

}
