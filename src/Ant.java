import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Ant {
	
	//Purpose ==> each time the queen call "giveBirth" i choose randomly between WORKER/FIGHTER
	/*public enum ANT_TYPES{
		QUEEN(1),
		WORKER(2){
			
			public Ant anfFactory() {
				
				return  new Worker(2, 2, Ant.setId());
			}
			
		},
		FIGHTER(3);
		
		private static ANT_TYPES[] types = ANT_TYPES.values(); 
		
		//Constructor
		ANT_TYPES(int type){
			this.type = type;
		}
		
		
		abstract Ant anfFactory();
		
		static Ant createFromIndex(int i) {
			
			ANT_TYPES.values()[i]
		}
		
		//public
	}*/
	String [] antTypes = {"QUEEN","WORKER","FIGHTER"};
	
	String id;
	int x, y;
	
	
	//constructor
	public Ant(int x, int y, String id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public int getPosition() {
		return 0;
	}
	
	public int setX(int x) {
		return x;
	}
	
	public int setY(int y) {
		return y;
	}
	
	public int  move(int x, int y) {
		return 0;
	}
	
	//
	public static Ant createAnt(int i) {
		Ant ant = null;
		
		//ANT_TYPES.FIGHTER.ordinal();
		
		switch(i) 
		{
			case 1:
				ant = new Worker(2, 2, Ant.setId());
				break;
			case 2:
				ant = new Fighter(4, 4, Ant.setId());
				break;
		}
		
		return ant;
	}
	
	public static String setId() {
		final String uuid = UUID.randomUUID().toString().replace("-", "");
	    //System.out.println("uuid = " + uuid);
	    return uuid;
	}
	
	
	
	
	
}
