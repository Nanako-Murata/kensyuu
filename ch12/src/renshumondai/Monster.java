package renshumondai;

public abstract class Monster {
	String name;
	public void attack(){
		System.out.println(this.name + "に攻撃された！");
	}

}
