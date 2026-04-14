package ch5;

public class Main5_renshumondai5_4bekkai {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double triangleArea = calcTriangleArea(10.0, 5.0);
		System.out.println("三角形の面積：" + triangleArea + "平方cm");
		double circleArea = calcCircleArea(5.0);
		System.out.println("三角形の面積：" + circleArea + "平方cm");

	}

	public static double calcTriangleArea(double bottom, double heigh) {
		double area = (bottom * heigh) / 2;
		return area;

	}

	public static double calcCircleArea(double hankei) {
		double area = hankei * hankei * 3.14;
		return area;
	}

}
