package chapter5.program1;

import java.util.Set;
import java.util.HashSet;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HumanResource hr = new HumanResource();
		hr.name = "伊藤";
		Sales sl = new Sales();
		sl.name = "橋本";
		Engineer en = new Engineer();
		en.name = "鈴木";
		en.language = "Python";

		// すべてのインスタンスをEmployeeにする
		Employee em1 = hr;
		Employee em2 = sl;
		Employee em3 = en;

		// 全従業員の名前を表示
		Set<String> allEmpsName = new HashSet<>();
		allEmpsName.add(hr.name);
		allEmpsName.add(sl.name);
		allEmpsName.add(en.name);
		for (String name : allEmpsName) {
			System.out.println(name);
		}

		// 部署を表示
		BT.dptList();

		// 従業員作成
		hr.Interview();

		// 週報返信
		sl.Report();
		// 面談を組む
		sl.meet(en);
		// 打合せ
		sl.uchiawase();
		// 従業員情報表示
		sl.expressInfo();
		// 開発実施
		en.develop();

	}
}