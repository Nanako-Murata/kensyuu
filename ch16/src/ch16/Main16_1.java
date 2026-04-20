package ch16;

import java.util.ArrayList;

//ラッパークラスをArrayyListに格納する
public class Main16_1 {
	public static void main(String[] args) {
		ArrayList<Integer> points = new ArrayList<>();
		points.add(10);
		points.add(80);
		points.add(100);
		System.out.println(points);
		for (int i : points) {
			System.out.println(i);
		}

	}

}
