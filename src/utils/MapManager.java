package utils;

import java.util.Scanner;

import entities.Position;
import entities.Queen;
import entities.QueenChildren;

public class MapManager {
	public static final String ANSI_RED = "\u001B[31m";
	int width;
	int height;
	static String[][] map;
    Queen redQueen;
    Queen blueQueen;
    private static final MapManager singletonInstance;

    static {
        singletonInstance = new MapManager();
    }

    private MapManager() {
    }

    public static MapManager getInstance() {
        return singletonInstance;
    }
    
    public void initMap() {
    	Scanner sc = new Scanner(System.in);

		//set width & height of map:
		System.out.print("Give map width: ");
		String widthStr = sc.nextLine();
		System.out.print("Give map height: ");
		String heightStr = sc.nextLine();
		width = Integer.parseInt(widthStr);
		height = Integer.parseInt(heightStr);
    	map = new String[width][height];
    	this.blueQueen = new Queen(new Position(0, 0));
    	printColonyOnMap(blueQueen);
    	this.redQueen = new Queen(new Position(width - 1, height - 1));
    	printColonyOnMap(redQueen);
    }
    
    public String[][] getMap() {
    	return map;
    }
    
    private static void printColonyOnMap(Queen queen) {
    	map[queen.getPosition().getX()][queen.getPosition().getY()] = ANSI_RED + AntType.QUEEN.getBadge();
    	queen.getFighters().forEach(MapManager::printAntOnMap);
    	queen.getWorkers().forEach(MapManager::printAntOnMap);
	}
    
    private static void printAntOnMap(QueenChildren ant) {
    	map[ant.getPosition().getX()][ant.getPosition().getY()] = ANSI_RED + ant.getAntType().getBadge();
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
    
    

}
