package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Ant {
	private String color;
	String type;
	
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	String [] antTypes = {"QUEEN","WORKER","FIGHTER"};
	
	public String id;
	public String label;
	public int x, y;
	
	public Ant(int x, int y, String id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public static int getPosition() {
		return 0;
	}
	
	public static int setX(int x) {
		return x;
	}
	
	public static int setY(int y) {
		return y;
	}
	
	public int  move(int x, int y) {
		return 0;
	}
	

	public static Ant createAnt(int i) {
		Ant ant = null;
		
		//ANT_TYPES.FIGHTER.ordinal();
		
		switch(i) 
		{
			case 0:
				ant = new Queen(0, 0, Ant.setId());
				break;
			case 1:
				ant = new Worker(0, 0, Ant.setId());
				break;
			case 2:
				ant = new Fighter(0, 0, Ant.setId());
				break;
		}
		
		return ant;
	}
	
	public static String setId() {
		final String uuid = UUID.randomUUID().toString().replace("-", "");
	    //System.out.println("uuid = " + uuid);
	    return uuid;
	}
	
	public void killEnemy(Queen defender, int x, int y) {
		for(Ant child : defender.ants) {
			if (child.x == x && child.y == y) {
				// remove it
				defender.ants.remove(child);
				break;
			}
		}
	}

	public abstract String getBadge(String color);
	
	public abstract boolean checkAround(Queen attacker, Queen defender);
	
}
