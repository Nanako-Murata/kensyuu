package ch15;

import java.time.*;
//Periodクラスの練習

public class Main15_17 {
	public static void main(String[] args) {
		LocalDate d1 = LocalDate.of(2020, 1, 1);
		LocalDate now = LocalDate.now();

		// 3日間を表示してみる
		Period p1 = Period.ofDays(3);
		System.out.println(p1);

		// d1からnowまでの間隔を表示してみる
		Period p2 = Period.between(d1, now);
		System.out.println(p2);

		/*
		 * ある時点が今から1年以上前の時、「これは昔の話です」を表示させたい しかし期間p1の大小をどう表せばいいか分からない
		 */

	}

}
