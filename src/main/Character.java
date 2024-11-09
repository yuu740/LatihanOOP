package main;

public class Character {
	private String name;
	private int dmg;
	private int hp;
	
	public Character(String name, int dmg, int hp) {
		super();
		this.name = name;
		this.dmg = dmg;
		this.hp = hp;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDmg() {
		return dmg;
	}

	public void setDmg(int dmg) {
		this.dmg = dmg;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public String getId() {
		return "##";
	}
	
	
	
}
