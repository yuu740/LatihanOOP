package main;

public class History {
	private static int fCount = 1;
	private String fighter1;
	private String fighter2;
	private String id;
	
	public History(String fighter1, String fighter2) {
		super();
		this.fighter1 = fighter1;
		this.fighter2 = fighter2;
		this.id = generateId();
	}
	
	public String generateId() {
		return "F"+fCount++;
	}

	public String getFighter1() {
		return fighter1;
	}

	public void setFighter1(String fighter1) {
		this.fighter1 = fighter1;
	}

	public String getFighter2() {
		return fighter2;
	}

	public void setFighter2(String fighter2) {
		this.fighter2 = fighter2;
	}

	public String getId() {
		return id;
	}

}
