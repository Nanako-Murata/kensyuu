package ch16;

//Setから要素を取り出す
import java.util.Set;
import java.util.HashSet;

public class Main16_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> names = new HashSet<String>();
		names.add("sato");
		names.add("ito");
		names.add("Ishikawa");
		for (String s : names) {
			System.out.println(s);
		}

	}

}
