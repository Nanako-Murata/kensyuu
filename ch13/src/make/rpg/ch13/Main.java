package make.rpg.ch13;
//getterの練習

//instanceofの練習

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hero h = new Hero();
		Character c = new King();
		if (c instanceof King) {
			((King) c).talk(h);
		}
	}

}
