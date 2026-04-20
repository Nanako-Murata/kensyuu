package ch16;

import java.util.*;

//マップに格納された情報を取り出す
public class Main16_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> prefs = new LinkedHashMap<String, Integer>();
		prefs.put("Tokyo", 1);
		prefs.put("Kanagawa", 2);
		prefs.put("Nagano", 3);
		prefs.put("Okinawa", 4);
		for (String key : prefs.keySet()) {
			int value = prefs.get(key);
			System.out.println(key + " is number " + value + " prefecture.");
		}

	}

}
