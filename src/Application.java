import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import entities.Ant;
import entities.Queen;
import utils.MapManager;

public class Application {
	
	private static MapManager mapManager = MapManager.getInstance();
	
	public static void newLine(int i) {
		for(int j = 0; j < i; j++) {
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//fill map and draw it
		mapManager.initMap();
		int w = mapManager.getWidth();
		int h = mapManager.getHeight();
		
		//create queens set his params
		Queen q1 = mapManager.initQueenPos(1, 1, "RED");
		q1.ants = q1.giveBirth();
		
		Queen q2 = mapManager.initQueenPos(w-2, h-2, "GREEN");
		q2.ants = q2.giveBirth();
		
		mapManager.printResource("fo");
		mapManager.printResource("wa");
		
		newLine(1);
		
		System.out.println("Reine posX:"+q1.x+" posY:"+q1.y+" id:"+q1.id);
		
		//update map with queen posX & Y then re-draw the map
		//map[q1.x][q1.y] = "q1";
		//map[q2.x][q2.y] = "q2";
		System.out.println("Map after set queen position");
		mapManager.drawMap(w, h);
		
		//set pos of children:
		mapManager.initChildPos(1, q1);
		mapManager.initChildPos(-1, q2);
		
		System.out.println("Map after set queen children pos:");
		mapManager.drawMap(w, h);
		
		newLine(2);
		
		//simulation loop:
		int newX = 0; 
		int newY = 0;
		
		System.out.print("before loop");
		
		if(mapManager.getMap()[1][1].equals("Q")) {
			System.out.print("fouded");
		}
		String current = "RED";
		boolean gameOver = false;
		int i = 0;
		while (!gameOver) {
			System.out.println("tour nb: "+i);
			try {
				
				//generate random XY for each child
				gameOver = mapManager.moveChilds(newX, newY, "RED".equals(current)? q1: q2, "RED".equals(current)? q2: q1);
				
				mapManager.drawMap(w, h);
				
				newLine(2);
				
	            Thread.sleep(500);
	            i++;
	            current = "RED".equals(current) ? "BLUE" : "RED";
	        } catch (InterruptedException ie)
	        {
	            System.out.println("Scanning...");
	            Thread.currentThread().interrupt();
	        }
		}
		
		System.out.println(current + "WINS!!!");
		

	}

}
