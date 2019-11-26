package entities;

public class Worker extends Ant {
	
	
	public Worker(int x, int y, String id) {
		super(x, y, id);
		this.type = "W";
		// TODO Auto-generated constructor stub
	}
	boolean food = false;
	boolean water = false;

	public void getFood(boolean fd) {
		
	}

	@Override
	public String getBadge(String color) {
		// TODO Auto-generated method stub
		if(color.equals("RED")) {
			return "\u001b[31mW "+"\u001b[0m";
		}else {
			
			return "\033[32mW "+"\u001b[0m";
		}
	}

	@Override
	public boolean checkAround(Queen attacker, Queen defender) {
		System.out.println("CHECK FROM WORKER");
		// TODO Auto-generated method stub
		return false;
	}
	
	/*
	 * getFood() ==> set food boolean to true until the worker return to the  queen
	 * 
	 * getWater() ==> set water boolean to true until the worker return to the  queen
	 * */
	
	

}
