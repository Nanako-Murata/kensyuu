package ch1;
/*
 * 書き換えてはいけない変数の扱い
 */
public class Main1_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final double PI = 3.14;
		int pie = 5;
		System.out.println("半径" + pie +"cmのパイの面積は、");
		System.out.println(pie * pie * PI);
		System.out.println("パイの半径を倍にします");
		System.out.println("半径" + pie + "cmのパイの面積は、");
		System.out.println(pie * pie * PI);
		

	}

}
