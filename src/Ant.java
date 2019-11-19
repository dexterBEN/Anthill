import java.util.UUID;

public abstract class Ant {
	
	//Purpose ==> each time the queen call "giveBirth" i choose randomly between WORKER/FIGHTER
	/*public enum ANT_TYPES{
		QUEEN(1),
		WORKER(2),
		FIGHTER(3);
		
		private static ANT_TYPES[] types = ANT_TYPES.values(); 
		
		//Constructor
		ANT_TYPES(int type){
			this.type = type;
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
	
	public int setX() {
		return 0;
	}
	
	public int setY() {
		return 0;
	}
	
	public int  move(int x, int y) {
		return 0;
	}
	
	//
	public static Ant createAnt(int i) {
		Ant ant = null;
		switch(i) 
		{
			case 1:
				ant = new Worker(2, 2, "978675689");
				break;
			case 2:
				ant = new Fighter(4, 4, "456787656");
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
