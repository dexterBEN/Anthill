
public class Ant {
	
	//Purpose ==> each time the queen call "giveBirth" i choose randomly between WORKER/FIGHTER
	public enum AntType{
		QUEEN,
		WORKER,
		FIGHTER
	}
	
	String id;
	int coordinates[][];
	
	
	//constructor
	public Ant(int coordinates[][], String id) {
		this.coordinates = coordinates;
		this.id = id;
	}
	
	public int[][] getCoordinates() {
		return null;
	}
	
	public int[][] setCoordinates() {
		return null;
	}
	
	public int[][]  move(int coordinates[][]) {
		return null;
	}
	
	
	
	
}
