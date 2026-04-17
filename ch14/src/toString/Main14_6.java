package toString;

public class Main14_6 {
	public static void main(String[] args) {
		Hero h1 = new Hero();
		h1.name = "Taro";
		h1.hp = 100;
		Hero h2 = new Hero();
		h2.name = "Taro";
		h2.hp = 100;
		if (h1.equals(h2) == true) {
			System.out.println("same");
		} else {
			System.out.println("different");
		}

	}

}
