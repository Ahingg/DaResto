package model;


public class Restaurant {
	private String name;
	private Integer gold;
	private Integer seat;
	private Integer score;
	
	public Restaurant() {
		super();
		this.name = "";
		this.gold = 1300;
		this.seat = 4;
		this.score = 0;
	}
	
	
	// Seat Section
	public Integer getSeat() { return seat; }

	public void upSeat() {
		if(seat >= 13) {
			System.out.println("Max Seat Reached!");
			return;
		}
		this.seat++;
	}
	
	
	
	public Integer getUpgradeSeatCost() { return 100 * seat; }

	public Integer getAvailableSeats(Integer customerCount) { return seat - customerCount; }
	// =================================================
	
	// Name Section
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	// =================================================
	
	
	// Gold Section
	public Integer getGold() {
		return gold;
	}

	public void addGold(Integer gold) {
		this.gold += gold;
	}
	
	public void reduceGold(Integer gold) {
		this.gold -= gold;
	}
	// =================================================
	
	
	// Score Section
	
	public Integer getScore() {
		return score;
	}



	public void addScore(Integer score) {
		this.score += score;
	}

	
	public boolean compareBalance(Integer reqGold) {
		return gold >= reqGold;
	}

	// ===================================================
}
