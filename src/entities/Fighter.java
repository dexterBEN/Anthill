package entities;
import java.util.Random;

import utils.MapManager;

public class Fighter extends Ant{

	public Fighter(int x, int y, String id) {
		super(x, y, id);
		this.type = "F";
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getBadge(String color) {
		// TODO Auto-generated method stub
		
		if(color.equals("RED")) {
			return "\u001b[31mF "+"\u001b[0m";
		}else {
			
			return "\033[32mF "+"\u001b[0m";
		}
	}

	@Override
	public boolean checkAround(Queen attacker, Queen defender) {
		System.out.println("CHECK FROM FIGHTER");
		// TODO Auto-generated method stub
		MapManager mapManager = MapManager.getInstance();
		String enemy = "\u001b[31m";
		if("RED".equals(this.getColor())) {
			enemy="\\033[32m";
		}
		
		if(mapManager.getMap()[this.x][this.y+1].contains(enemy)) {
			mapManager.getMap()[this.x][this.y+1] = "  ";
			killEnemy(defender, this.x, this.y+1);
			return defender.ants.isEmpty() || mapManager.getMap()[this.x][this.y+1].contains("Q")? true : false;
		}else if(mapManager.getMap()[this.x-1][this.y].contains(enemy) ) {
			mapManager.getMap()[this.x-1][this.y] = "  ";
			killEnemy(defender, this.x-1, this.y);
			return defender.ants.isEmpty() || mapManager.getMap()[this.x-1][this.y].contains("Q")? true : false;
		}else if(mapManager.getMap()[this.x][this.y-1].contains(enemy) ) {
			mapManager.getMap()[this.x][this.y-1] = "  ";
			killEnemy(defender, this.x, this.y-1);
			return defender.ants.isEmpty() || mapManager.getMap()[this.x][this.y-1].contains("Q")? true : false;
		}else if(mapManager.getMap()[this.x+1][this.y].contains(enemy) ) {
			mapManager.getMap()[this.x+1][this.y] = "  ";
			killEnemy(defender, this.x+1, this.y);
			return defender.ants.isEmpty() || mapManager.getMap()[this.x+1][this.y].contains("Q")? true : false;
		}
		return false;
	}

	
	
	/*
	 * checkEnemy() ==> checkEnemy if their are enemy in the sale
	 * attackEnemy("Antype") ==> according to the antTYpe the Fighter survive or not
	 * */
	
	

}
