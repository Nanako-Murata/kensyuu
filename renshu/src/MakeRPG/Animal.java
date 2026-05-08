package MakeRPG;

public abstract class Animal implements Character {
	private String name;
	int age;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void eat(String food) {
		System.out.println(this.name + " ate " + food + ".");

	}

	public void drink() {
		System.out.println(this.name + " drunk water");
	}

	public void play(String toy) {
		System.out.println(this.name + "played with " + toy + ".");
	}

}
