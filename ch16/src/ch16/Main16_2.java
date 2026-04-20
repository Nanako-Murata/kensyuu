package ch16;

import java.util.ArrayList;
import java.util.Iterator;

//イテレータを使ったArrayListの繰り返し処理
public class Main16_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> names = new ArrayList<String>();
		names.add("Sato");
		names.add("Ito");
		names.add("Suzuki");
		Iterator<String> it = names.iterator();
		while (it.hasNext()) {
			String e = it.next();
			System.out.println(e);
		}

	}

}
