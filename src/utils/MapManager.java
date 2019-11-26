package utils;

import java.util.Random;
import java.util.Scanner;

import com.sun.javafx.collections.MapAdapterChange;
import com.sun.javafx.scene.traversal.WeightedClosestCorner;

import entities.Ant;
import entities.Fighter;
import entities.Queen;
import entities.Worker;

public class MapManager {
	
	private  int width;
	private int height;
	private String RED =  "\u001b[31m";
	private String GREEN = "\033[32m";
	private String [][] mapArray;
	private static final MapManager singletonInstance;
	static {
		singletonInstance = new MapManager();
	}
	
	private MapManager() {
		//System.out.print("instanciation du singleton");
	}
	
	public static MapManager getInstance(){
		return singletonInstance;
	}
	
	public String [][] getMap(){
		return mapArray;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void initMap(){
		
		Scanner sc = new Scanner(System.in);
		Random randInt = new Random();
		
		//set width & height of map:
		System.out.print("Give map width: ");
		String widthStr = sc.nextLine();
		System.out.print("Give map height: ");
		String heightStr = sc.nextLine();
		 width = Integer.parseInt(widthStr);
		 height = Integer.parseInt(heightStr);
		 mapArray = new String [width][height];
		
			for(int i = 0; i < width; i++) 
			{
				for(int j = 0; j < height; j++) 
				{
					if( (i > 0 && i < (width-1)) && (j > 0 && j < (height-1))) 
					{
						mapArray[i][j] = "  ";
					}else {
						mapArray[i][j] = "* ";
					}
				}
			}
			
			//set food:
			//mapArray[randInt.nextInt((width-2)+1) + 1][randInt.nextInt((height-2)+1) + 1] = "fo";
			//mapArray[randInt.nextInt((width-2)+1) + 1][randInt.nextInt((height-2)+1) + 1] = "wa";
	}
	
	public Queen initQueenPos(int posX, int posY, String color) {
		Queen queen = (Queen) Ant.createAnt(0);
		queen.setColor(color);
		queen.x = posX; 
		queen.y = posY;
		
		mapArray[posX][posY] = queen.getBadge(queen.getColor());
		return queen;
	}
	
	public void initChildPos(int n, Queen queen) {
		int x = n;
		int y = n;
		
		for(Ant child :queen.ants)
		{
			child.x = queen.x;
			child.y = queen.y +x;
			mapArray[child.x][child.y] = child.getBadge(queen.getColor());
			x = x+y;
		}
	}
	
	public boolean moveChilds(int x, int y, Queen attacker, Queen defender) {
		Random randInt = new Random();
		boolean gameOver = false;
		for(Ant children: attacker.ants) {
			x = randInt.nextInt((width-2)+1) + 1;
			System.out.print("New x:"+x);
			
			y = randInt.nextInt((height-2)+1) + 1;
			System.out.println("New y: "+y);
			
			//check if new pair [X][Y] is free:
			if(isFree(mapArray[x][y])) {
				
				//free space:
				mapArray[children.x][children.y] = freeSpace();
				
				children.x = x;
				children.y = y;
			}
			//check
			gameOver = children.checkAround(attacker, defender);
			
			
			
			mapArray[children.x][children.y] = printAntOnMap(children, attacker.getColor());
		}
		return gameOver;
	}
	
	public void drawMap( int w, int h) {
		
			for(int i = 0; i < w; i++){
				
		      for(int j = 0; j < h; j++){
		        System.out.print(mapArray[i][j]);
		      }
		      System.out.println();
		    }
	}
	
	public static String printAntOnMap(Ant ant, String color) {
		return ant.getBadge(color);
		
	}
	
	public void printResource(String resourceType) {
		Random randInt = new Random();
		if("fo".equals(resourceType)) {
			mapArray[randInt.nextInt((width-2)+1) + 1][randInt.nextInt((height-2)+1) + 1] = "fo";
		}else if("wa".equals(resourceType)) {
			mapArray[randInt.nextInt((width-2)+1) + 1][randInt.nextInt((height-2)+1) + 1] = "wa";
		}
	}
	
	public static String freeSpace() {
		return "  ";
	}
	
	public static boolean isFree(String space) {
		//return space != "e " || space != "* ";
		return "  ".equals(space);	
	}
	
}
