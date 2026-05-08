package renshumondai;
//Object, toStringの練習
public class Kouza {
	String accountNumber; // 口座番号
	int balance; // 残高

	public String toStringA() {
		return "\\" + this.balance + "(口座番号" + this.accountNumber + ")";
	}

	public boolean eqauls(Object o) {
		if (this == o) {
			return true;
		}
		if (o instanceof Kouza) {
			Kouza k = (Kouza) o;
			String k1 = this.accountNumber.trim();
			String k2 = k.accountNumber.trim();
			if (k1.equals(k2)) {
				return true;
			}

		}
		return false;
	}

}
