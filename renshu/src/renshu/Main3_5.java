package renshu;

//drill switch sentence
public class Main3_5 {
	public static void main(String[] args) {
		int fortune = new java.util.Random().nextInt(5);
		switch (fortune) {
		case 1:
			System.out.println("You are lucky.");
			break;
		case 2:
		case 3:
			System.out.println("You are not lucky.");
			break;
		case 0:
		case 4:
			System.out.println("maybe you are not lucky.");
			break;
		}

	}
}
