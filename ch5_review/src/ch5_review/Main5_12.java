package ch5_review;

/*
 * when an argument is array
 * with an arugment, write law in sub-method
 * with an argument, write input-value in main method
 * output the result from sub-method
 */
public class Main5_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1, 2, 3 }; // 代入する配列を記述
		// []で配列であることを指定する
		calc(array);

	}

	public static void calc(int[] array) {
		//int型の配列を指定
		for (int element : array) {
			System.out.println(element);
		}
	}

}
