package ch15;

import java.time.*;
import java.time.format.*;

//各種日時クラスのメソッド利用例
public class Main15_16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 文字列からLocalDateを生成する
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate ld1 = LocalDate.parse("2020/09/22", fmt);
		// 1000日後を計算する
		LocalDate ld2 = ld1.plusDays(1000);
		String str1 = ld1.format(fmt);
		String str2 = ld2.format(fmt);

		System.out.println(str1);
		System.out.println(str2);

		// 今日との比較
		LocalDate now = LocalDate.now();
		if (now.isAfter(ld2)) {
			System.out.println("1000日後は過去の日付");

		} else {
			System.out.println("1000日後は未来の日付かもしれない");
		}

	}

}
