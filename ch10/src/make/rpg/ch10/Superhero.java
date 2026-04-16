package make.rpg.ch10;

public class Superhero extends Hero {
	boolean flying;

	public void fly() {
		this.flying = true;
		System.out.println("飛び上がった！");

	}

	public void land() {
		this.flying = false;
		System.out.println("着地した！");
	}

	public void run() {
		System.out.println("スーパーヒーローなのに逃げ出した！");
	}

}
