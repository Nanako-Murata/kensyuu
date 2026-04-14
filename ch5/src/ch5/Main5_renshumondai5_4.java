package ch5;

public class Main5_renshumondai5_4 {
	public static void main(String[] args) {
		System.out.println("三角形の面積を計算します。");
		System.out.println("底辺の長さを小数点下一桁まで記入してください　例2.0");
		double teihen = new java.util.Scanner(System.in).nextDouble();
		System.out.println("高さを小数点下一桁まで記入してください　例3.0");
		double heigh = new java.util.Scanner(System.in).nextDouble();
		System.out.println("三角形の面積は" + teihen * heigh/2 + "です");
	}

}
