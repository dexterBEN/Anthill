package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Queen extends Ant{
	
	public Queen(int x, int y, String id) {
		super(x, y, id);
		this.type = "Q";
		// TODO Auto-generated constructor stub
	}

	public List <Ant> ants = new ArrayList<Ant>();

	//called at the beginning and thrice when queen receive water or food 
	public List<Ant> giveBirth() {
		
		List <Ant> ants = new ArrayList<Ant>();
		Random randInt = new Random();
		int randomIndex;
		randomIndex = randInt.nextInt((2-1)+1) + 1;
		
		ants.add(Ant.createAnt(1));
		ants.add(Ant.createAnt(2));
		ants.add(Ant.createAnt(randomIndex));
		
		return ants;
	}

	@Override
	public String getBadge(String color) {
		
		if(color.equals("RED")) {
			return "\u001b[31mQ "+"\u001b[0m";
		}else {
			
			return "\033[32mQ "+"\u001b[0m";
		}
	}

	@Override
	public boolean checkAround(Queen attacker, Queen defender) {
		// TODO Auto-generated method stub
		return false;
		
	}
}
