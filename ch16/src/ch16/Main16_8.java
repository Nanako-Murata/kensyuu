package ch16;

//リストに格納したものを書き換えて出力する
import java.util.*;

//リストに格納した勇者の名前を取り出す
public class Main16_8 {
	public static void main(String[] args) {
		Hero h = new Hero();
		h.name = "Sato";
		List<Hero> list = new ArrayList<Hero>();
		list.add(h);
		h.name = "Tanaka";
		System.out.println("Hero is " + h.name + ".");

	}

}