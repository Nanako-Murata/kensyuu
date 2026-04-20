package ch16;

import java.util.HashSet;
import java.util.Set;

//Setに重複した値を追加しようとすると無視される
public class Main16_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> colors = new HashSet<String>();
		colors.add("red");
		colors.add("blue");
		colors.add("black");
		colors.add("red");
		System.out.println(colors.size());

	}

}
