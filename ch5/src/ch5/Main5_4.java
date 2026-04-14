package ch5;

//引数の例(渡す値が1つの場合)
public class Main5_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("メソッドを呼び出します");
		hello("湊");
		hello("朝香");
		hello("菅原");
		System.out.println("メソッドの呼び出しが終わりました");

	}

	public static void hello(String name) {
		System.out.println(name + "さん、こんにちは");
	}

}
