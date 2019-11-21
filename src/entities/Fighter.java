package entities;
import java.util.UUID;

public class Fighter extends Ant{

	public Fighter(int x, int y, String id) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getBadge() {
		// TODO Auto-generated method stub
		return "f ";
	}

	
	
	/*
	 * checkEnemy() ==> checkEnemy if their are enemy in the sale
	 * attackEnemy("Antype") ==> according to the antTYpe the Fighter survive or not
	 * */
	
	

}
