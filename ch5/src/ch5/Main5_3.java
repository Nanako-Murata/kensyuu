package ch5;

//mainメソッド以外からメソッドを呼び出す
public class Main5_3 {

	public static void methodA() {
		// TODO Auto-generated method stub
		System.out.println("methodA");
		methodB();

	}
	public static void methodB() {
		System.out.println("methodB");
	}
	public static void main(String[]  args) {
		methodA();
	}

}
