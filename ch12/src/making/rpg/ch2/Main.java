package making.rpg.ch2;

//多態性の練習
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Character c = new Wizard();
		Wizard w = (Wizard)c;
		w.fireball(null);
	}

}
