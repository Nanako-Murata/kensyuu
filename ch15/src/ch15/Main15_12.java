package ch15;

import java.util.Date;
import java.util.Calendar;

public class Main15_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar c = Calendar.getInstance();
		// 6つのint値からdateのインスタンスを生成
		c.set(2026, 4, 17, 1, 1, 1);
		c.set(Calendar.MONTH, 3);
		Date d = c.getTime();
		System.out.println(d);
		// dateインスタンスからint値を生成
		Date now = new Date();
		c.setTime(now);
		int y = c.get(Calendar.YEAR);
		System.out.println("今年は" + y + "年です。");

	}

}
