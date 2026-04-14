package ch5;

//overload (引数の数が異なる場合)
public class Main5_11 {
	// 1つめのadd method, 2つの数を足す
	public static int add(int x, int y) {
		return x + y;
	}

	// 2つめのadd method, 3つのすうを足す
	public static int add(int x, int y, int z) {
		return x + y + z;
	}

	public static void main(String[] args) {
		System.out.println(add(1, 2));
		System.out.println(add(3, 4, 5));

	}

}
