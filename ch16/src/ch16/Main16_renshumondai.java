package ch16;

import java.util.*;

//練習問題16_2
public class Main16_renshumondai {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hero h1 = new Hero();
		h1.setName("齋藤");
		Hero h2 = new Hero();
		h2.setName("鈴木");
		ArrayList<Hero> heroname = new ArrayList<Hero>();
		heroname.add(h1);
		heroname.add(h2);
		for (Hero h : heroname) {
			System.out.println(h.getName());
		}

	}

}
