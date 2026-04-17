package ch15;
import java.util.Date;

//現在日時を表示する
public class Main15_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date now = new Date();
		System.out.println(now);
		System.out.println(now.getTime());
		Date past = new Date(10000000000000L);
		System.out.println(past);

	}

}
