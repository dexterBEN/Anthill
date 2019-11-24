package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Ant {
	
	//Purpose ==> each time the queen call "giveBirth" i choose randomly between WORKER/FIGHTER
//	public enum ANT_TYPES{
//		QUEEN("Q"),
//		WORKER(2){
//			
//			public Ant anfFactory() {
//				
//				return  new Worker(2, 2, Ant.setId());
//			}
//			
//		},
//		FIGHTER(3);
//		
//		private static ANT_TYPES[] types = ANT_TYPES.values(); 
//		
//		//Constructor
//		ANT_TYPES(int type){
//			this.type = type;
//		}
//		
//		
//		abstract Ant anfFactory();
//		
//		static Ant createFromIndex(int i) {
//			
//			ANT_TYPES.values()[i]
//		}
//		
//		//public
//	}
	String [] antTypes = {"QUEEN","WORKER","FIGHTER"};
	
	public String id;
	public int x, y;
	
	
	//constructor
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
	
	//
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

	public abstract String getBadge();
	
}
