import java.nio.charset.Charset;
import java.util.Random;
import java.util.Scanner;

public class Application {
	
	public static void newLine() {
		System.out.println();
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		MapManager mapManager = MapManager.getInstance();
		String [][] map;
		
		//set width & height of map:
		System.out.print("Give map width: ");
		String width = sc.nextLine();
		System.out.print("Give map height: ");
		String height = sc.nextLine();
		int w = Integer.parseInt(width);
		int h = Integer.parseInt(height);
		
		//fill map and draw it
		map = mapManager.initMap(w, h);
		//mapManager.drawMap(map, w, h);
		
		//create queen set his params
		Queen q1 = new Queen(1, 1, Ant.setId());
		q1.ants = q1.giveBirth();
		
		int nb= 1;
		
		
		/*for(Ant children: q1.ants) 
		{
			//System.out.println(nb+" Child:"+children.id);
			if(children instanceof Worker) {
				System.out.println("Children "+nb+": worker");
			}else if(children instanceof Fighter) {
				System.out.println("Children "+nb+": fighter");
			}
			nb++;
		}*/
		
		newLine();
		
		System.out.println("Reine posX:"+q1.x+" posY:"+q1.y+" id:"+q1.id);
		
		//update map with queen posX & Y then re-draw the map
		map[q1.x][q1.y] = "q1";
		System.out.println("Map after set queen position");
		mapManager.drawMap(map, w, h);
		
		//set pos of children:
		int y = q1.y;
		for(Ant children: q1.ants) {
			
			map[q1.x][y = y+1] = mapManager.printAntOnMap(children);
		}
		
		System.out.println("Map after set queen children pos:");
		mapManager.drawMap(map, w, h);
		
		
		

	}

}
