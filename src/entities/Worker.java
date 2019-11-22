package entities;

import utils.AntType;

public class Worker extends QueenChildren {
	
	boolean isCharged = false;
	
	public Worker(Position position) {
		super(position, AntType.WORKER);
	}
	

}
