package chapter5.program1;

//営業クラス
public class Sales extends Employee {
	//属性
	static String department ="営業";
	// 操作
	// 週報返信
	public void Report() {
		System.out.println("週報を返信した");

	}

	// 面談を組む
	public void meet(Engineer eng) {
		System.out.println(eng.name + "の面談を組んだ");
	}

	// 打合せ
	public void uchiawase() {
		System.out.println("新規の打ち合わせをした");
	}

	// 情報表示
	public void expressInfo() {
		System.out.println(this.name + ":" + department);
	}

}
