import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Queen extends Ant{
	
	public Queen(int x, int y, String id) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
	}



	List <Ant> ants = new ArrayList<Ant>();

	
	
	//called at the beginning and thrice when queen receive water or food 
	public Ant giveBirth(int i) {
		Ant ant = null;
		ant = Ant.createAnt(i);
		return ant;
	}
	
	
	
	
	

}
