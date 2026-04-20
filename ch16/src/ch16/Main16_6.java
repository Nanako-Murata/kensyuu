package ch16;

import java.util.*;
//HashMapクラスの利用

public class Main16_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> prefs = new HashMap<String, Integer>();
		prefs.put("Tokyo", 1);
		prefs.put("Osaka", 2);
		prefs.put("Okinawa", 3);
		int TokyoNumber = prefs.get("Okinawa");
		System.out.println(TokyoNumber);
		prefs.remove("Osaka");
		prefs.put("Okinawa", 100);
		int TochigiNumber = prefs.get("Okinawa");
		System.out.println(TochigiNumber);
		System.out.println(prefs.size());

	}

}
