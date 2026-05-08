package ch16;

//リストに格納したものを書き換えて出力する
import java.util.*;

//リストに格納した勇者の名前を取り出す
public class Main16_8 {
	public static void main(String[] args) {
		Person sato = new Person();
		sato.name = "Sato";
		List<Person> list = new ArrayList<Person>();
		list.add(sato);
		sato.name = "Tanaka";
		System.out.println("Hero is " + sato.name + ".");

	}

}

class Person {
	public String name;
}