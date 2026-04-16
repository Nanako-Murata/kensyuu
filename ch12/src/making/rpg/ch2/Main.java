package making.rpg.ch2;

//多態性の練習
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Monster[] monsters = new Monster[3];
		monsters[0] = new Slime();
		monsters[1] = new Goblin();
		monsters[2] = new Bat();
		for (Monster m : monsters) {
			m.run();
		}

	}

}
