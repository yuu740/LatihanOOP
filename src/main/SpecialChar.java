package main;

import java.util.ArrayList;
import java.util.Arrays;

public class SpecialChar extends Character{
	private static int count = 1;
	private String id;
	private ArrayList<String> skill = new ArrayList<>();
	public SpecialChar(String name, int dmg, int hp, String... s) {
		super(name, dmg, hp);
		this.id = generateId();
		for (String sk : s) {
			this.skill.add(sk);
		}
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getId() {
		return id;
	}

	public String generateId() {
		return "sk"+count++;
	}

	public ArrayList<String> getSkill() {
		return skill;
	}

	

}
