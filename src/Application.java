import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import entities.Ant;
import entities.Queen;
import utils.MapManager;

public class Application {
	
	public static void newLine() {
		System.out.println();
		System.out.println();
	}
	
	public static void initChildPos(int n, Queen queen, String[][]map, MapManager mapManager) {
		int x = n;
		int y = n;
		
		for(Ant child :queen.ants)
		{
			child.x = queen.x;
			child.y = queen.y +x;
			map[child.x][child.y] = mapManager.printAntOnMap(child);
			x = x+y;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [][] map;
		Scanner sc = new Scanner(System.in);
		MapManager mapManager = MapManager.getInstance();
		Random randInt = new Random();
		
		//set width & height of map:
		System.out.print("Give map width: ");
		String width = sc.nextLine();
		System.out.print("Give map height: ");
		String height = sc.nextLine();
		int w = Integer.parseInt(width);
		int h = Integer.parseInt(height);
		
		//fill map and draw it
		map = mapManager.initMap(w, h);
		
		//create queens set his params
		Queen q1 = (Queen) Ant.createAnt(0);
		q1.x = q1.y = 1;
		q1.ants = q1.giveBirth();
		
		Queen q2 = (Queen) Ant.createAnt(0);
		q2.x = w-2; q2.y = h-2;
		q2.ants = q2.giveBirth();
		
		newLine();
		
		System.out.println("Reine posX:"+q1.x+" posY:"+q1.y+" id:"+q1.id);
		
		//update map with queen posX & Y then re-draw the map
		map[q1.x][q1.y] = "q1";
		map[q2.x][q2.y] = "q2";
		System.out.println("Map after set queen position");
		mapManager.drawMap(map, w, h);
		
		//set pos of children:
		initChildPos(1, q1, map, mapManager);
		initChildPos(-1, q2, map, mapManager);
		
		System.out.println("Map after set queen children pos:");
		mapManager.drawMap(map, w, h);
		
		newLine();
		newLine();
		
		//simulation loop:
		int newX, newY;
		for(int i = 0; i <= 4; i++) {
			System.out.println("tour nb: "+i);
			try {
				
				//check position of each child:
				
				//generate random XY for each child
				for(Ant children: q1.ants) {
					newX = randInt.nextInt((w-2)+1) + 1;
					System.out.print("New x:"+newX);
					
					newY = randInt.nextInt((h-2)+1) + 1;
					System.out.println(" New y: "+newY);
					
					//check if new pair [X][Y] is free:
					if(mapManager.isEmpty(map[newX][newY])) {
						
						//free space:
						map[children.x][children.y] = mapManager.freeSpace();
						
						children.x = newX;
						children.y = newY;
						
						map[children.x][children.y] = mapManager.printAntOnMap(children);
						
					}else {
						
						children.x = children.x;
						children.y = children.y;
						map[children.x][children.y] = mapManager.printAntOnMap(children);
					}
				}
				
				System.out.println("queen 2: ");
				for(Ant children: q2.ants) {
					newX = randInt.nextInt((w-2)+1) + 1;
					System.out.print("New x:"+newX);
					
					newY = randInt.nextInt((h-2)+1) + 1;
					System.out.println(" New y: "+newY);
					
					//check if new pair [X][Y] is free:
					if(mapManager.isEmpty(map[newX][newY])) {
						
						//free space:
						map[children.x][children.y] = mapManager.freeSpace();
						
						children.x = newX;
						children.y = newY;
						
						map[children.x][children.y] = mapManager.printAntOnMap(children);
						
					}else {
						
						children.x = children.x;
						children.y = children.y;
						map[children.x][children.y] = mapManager.printAntOnMap(children);
					}
				}
				
				mapManager.drawMap(map, w, h);
				
				newLine();
				newLine();
	            Thread.sleep(5000);
	        } catch (InterruptedException ie)
	        {
	            System.out.println("Scanning...");
	            Thread.currentThread().interrupt();
	        }
		}
		

	}

}
