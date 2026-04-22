package chapter5.program1;

//人事クラス
public class HumanResource extends Employee {
	// 属性
	static String department = "人事部";
	String name;
	// 操作

	// 社員面接
	public void Interview() {
		int result = new java.util.Random().nextInt(5);
		if (result < 3) {
			System.out.println("面接を行い、結果は採用だった");
			// ここにMOAT methodを追記
			BT.makeEmployee("人事部");
		} else {
			System.out.println("面接を行い、結果は不採用だった");
		}

	}

	// 給与計算
	public void clacPay() {
		// Empty
	}

	// 情報表示
	public void expressInfo() {
		System.out.println(this.name + ":" + department);
	}

}
