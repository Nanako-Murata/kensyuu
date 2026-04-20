package ch17;

public class Person {
	int age;

	public void setAge(int age) {
		if (age < 0) {
			throw new IllegalArgumentException("Age must be above 0.");
		}
		this.age = age;
	}

}
