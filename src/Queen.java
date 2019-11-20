import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Queen extends Ant{
	
	public Queen(int x, int y, String id) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
	}

	List <Ant> ants = new ArrayList<Ant>();

	//called at the beginning and thrice when queen receive water or food 
	public List<Ant> giveBirth() {
		
		List <Ant> ants = new ArrayList<Ant>();
		Random randInt = new Random();
		int randomIndex;
		
		
		for(int i = 0; i <= 2; i++) 
		{
			randomIndex = randInt.nextInt((2-1)+1) + 1;
			ants.add(Ant.createAnt(randomIndex));
		}
		return ants;
	}
}
