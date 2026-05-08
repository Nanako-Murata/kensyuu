package chapter5.program1;

/*
 * BTにstaticをつける
 * BTにextendsをつける
 * switchではなくifを使う
 */
import java.util.*;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

//BTクラス
public class BT {
	// 属性
	// 会社名
	private String companyName;

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String name) {
		this.companyName = name;
	}

	/*
	 * 
	 * public static void empList(Employee... name) { Set<String> empsName = new
	 * HashSet<>(); empsName.add(Employee.name);
	 * 
	 * }
	 */

	// 部署リスト
	public static void dptList() {
		ArrayList<String> allDpt = new ArrayList<>();
		allDpt.add(HumanResource.department);
		allDpt.add(Sales.department);
		allDpt.add(Engineer.department);
		for (String dpt : allDpt) {
			System.out.println(dpt);
		}
	}

	// 操作

	/*
	 * 従業員作成メソッド 人事部のみアクセスできるようにする
	 */
	public static void makeEmployee(String caller) {

		if (caller == "人事部") {
			System.out.println("新人の配属先を検討中");
			int haizoku = new java.util.Random().nextInt(3);
			if (haizoku == 0) {
				HumanResource newHr = new HumanResource();
				System.out.println("新人を人事部に配属した");
				newHr.name = "new person";
				newHr.expressInfo();
			} else if (haizoku == 1) {
				Sales newSl = new Sales();
				System.out.println("新人を営業に配属した");
				newSl.name = "new person";
				newSl.expressInfo();

			} else {
				Engineer newEn = new Engineer();
				System.out.println("新人をエンジニアにした");
				newEn.name = "new person";

				int usingLanguage = new java.util.Random().nextInt(3);
				if (usingLanguage == 0) {
					newEn.language = "Java";
				}
				if (usingLanguage == 1) {
					newEn.language = "Python";
				} else {
					newEn.language = "other language";
				}
				newEn.expressInfo();

			}
		}
	}

	// 従業員情報開示 全従業員に情報表示させる
	public static void allEmpsInfo() {
		Set<Employee> allEmps = new HashSet<Employee>();
		for (Employee emp : allEmps) {
			emp.expressInfo();
		}
	}
}
