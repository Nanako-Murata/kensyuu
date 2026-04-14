package ch3;

public class Main3_renshumondai {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int isHungry = new java.util.Random().nextInt(2);
		String food = "bread";
		if (isHungry == 0) {
			System.out.println("おなかがいっぱいです");
		} else {
			System.out.println("はらぺこです");
			System.out.println(food + "をいただきます");
			System.out.println("ごちそうさまでした");
		}

	}

}
