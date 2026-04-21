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

	// 従業員リスト
	/*

	public static void allEmps() {
		ArrayList<String> allEmpsName = new ArrayList<String>();
		allEmpsName.add(HumanResource.name);
		allEmpsName.add(Sales.name);
		allEmpsName.add(Engineer.name);

	}
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
	public static void makeEmployee(Object instance) {
		if (instance instanceof HumanResource) {
			int haizoku = new java.util.Random().nextInt(3);

			if (haizoku == 0) {
				HumanResource hr = new HumanResource();
			}
			if (haizoku == 1) {
				Sales sl = new Sales();
			} else {
				Engineer en = new Engineer();
				int usingLanguage = new java.util.Random().nextInt(3);
				if (usingLanguage == 0) {
					en.language = "Java";
				}
				if (usingLanguage == 1) {
					en.language = "Python";
				} else {
					en.language = "other language";
				}

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
