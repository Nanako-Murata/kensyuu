package ch11;
//abstract classの作成

public abstract class Character implements Human{
	String name;
	int hp;
	
	public abstract void attack();
	public void run() {
		System.out.println("run");
	}

}
