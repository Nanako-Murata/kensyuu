package ch16;

import java.util.Set;
import java.util.TreeSet;

//TreeSetから文字列を取り出す
public class Main16_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> prefectures = new TreeSet<String>();
		prefectures.add("Tokyo");
		prefectures.add("Hokkaido");
		prefectures.add("Nagano");
		for(String s: prefectures) {
			System.out.println(s);
		}

	}

}
