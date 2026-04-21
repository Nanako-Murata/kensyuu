package chapter5.program1;

import java.util.*;

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
	public static void employeesList() {
		Set<String> employees = new HashSet<String>();
		employees.add(Employee.name);
		for (String names : employees) {
			System.out.println(names);

		}
	}

	// 部署リスト
	public static void departmentsList() {
		List<String> allDepartments = new ArrayList<String>();
		allDepartments.add(Employee.department);
		for (String dpt : allDepartments) {
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
			{
				switch (haizoku) {
				case 0:
					HumanResource hr = new HumanResource();
					break;
				case 1:
					Sales sl = new Sales();
					break;
				case 2:
					Engineer en0 = new Engineer();
					int usingLanguage = new java.util.Random().nextInt(3);
					switch (usingLanguage) {
					case 0:
						en0.language = "Java";
						break;
					case 1:
						en0.language = "python";
						break;
					case 2:
						en0.language = "other language";
						break;

					}
					break;
				}

			}

		}

	}

	// 従業員情報開示 全従業員に情報表示させる
	public static void allEmpsInfo() {
		sl instanceof Sales

	}

}
