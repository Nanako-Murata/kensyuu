package chapter5.program1;

//エンジニア
public class Engineer extends Employee {
	// 属性
	// 使用言語
	// java, python, other lauguageのいずれか
	String language;
	static String department = "エンジニア";

	// 開発実施
	public void develop() {
		System.out.println(this.language + "で開発を行った");
	}

	// 情報表示
	public void expressInfo() {
		System.out.println(this.name + ":" + department + " 使用言語:" + this.language);
	}

}
