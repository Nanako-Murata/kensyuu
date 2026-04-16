package ch11;

//interface Humanをimplementしたabstract class Characterからextendしてclass Satoを作成する
public class Sato extends Character {
	public void live() {
		System.out.println("live");

	}

	public void attack() {
		System.out.println("attack");
	}

}
