package entities;

public class Worker extends Ant {
	
	public Worker(int x, int y, String id) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
	}
	boolean food = false;
	boolean water = false;

	public void getFood(boolean fd) {
		
	}

	@Override
	public String getBadge() {
		// TODO Auto-generated method stub
		return "w ";
	}
	
	/*
	 * getFood() ==> set food boolean to true until the worker return to the  queen
	 * 
	 * getWater() ==> set water boolean to true until the worker return to the  queen
	 * */
	
	

}
