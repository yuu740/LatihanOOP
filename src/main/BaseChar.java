package main;

public class BaseChar extends Character {
	private static int idCount = 1;
	private String id;

	public BaseChar(String name, int dmg, int hp) {
		super(name, dmg, hp);
		this.id = generateId();
	}
	
	@Override
	public String getId() {
		return id;
		
	}
	
	public String generateId() {
		return "k"+idCount++;
	}
}
