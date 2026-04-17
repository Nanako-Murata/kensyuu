package ch15;

import java.time.*;

//LocalDateTimeの利用
public class Main15_15 {
	public static void main(String[] args) {
		// LocalDateTimeの生成方法
		LocalDateTime l1 = LocalDateTime.now();
		// LocalDateTimeとZonedDateTimeの相互変換
		ZonedDateTime z1 = l1.atZone(ZoneId.of("Europe/London"));
		LocalDateTime l2 = z1.toLocalDateTime();

		System.out.println(l1);
		System.out.println(z1);
		System.out.println(l2);
	}

}
