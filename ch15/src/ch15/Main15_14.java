package ch15;

import java.time.*;

//instantおよびZonedDateTimeの利用例
public class Main15_14 {
	public static void main(String[] args) {
		// instantの生成
		Instant i1 = Instant.now();
		// instantとlong値の相互変換
		Instant i2 = Instant.ofEpochMilli(1776410711054L);
		long l = i2.toEpochMilli();

		// zonedDateTimeの生成
		ZonedDateTime z1 = ZonedDateTime.now();
		ZonedDateTime z2 = ZonedDateTime.now();
		// instantとzonedDateTimeの相互変換
		// 東京で1月2日をロンドンの時間に変換
		Instant i3 = z2.toInstant();
		ZonedDateTime z3 = i3.atZone(ZoneId.of("Europe/London"));

		// ZonedDateTimeの利用方法
		System.out.println("東京は" + z2.getYear() + z2.getMonth() + z2.getDayOfMonth());
		System.out.println("ロンドンは" + z3.getYear() + z3.getMonth() + z3.getDayOfMonth());
		System.out.println(z2);

	}
}