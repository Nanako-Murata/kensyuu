package ch16;

import java.util.*;

//練習問題16-3
public class Main_renshumondai_16_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hero saito = new Hero();
		saito.setName("齋藤");
		Hero suzuki = new Hero();
		suzuki.setName("鈴木");
		Map<Hero, Integer> wins = new HashMap<Hero, Integer>();
		wins.put(saito, 3);
		wins.put(suzuki, 5);
		for (Hero key : wins.keySet()) {
			int value = wins.get(key);
			System.out.println(key.getName() + "が倒した敵の数 = " + value);
		}
	}

}
