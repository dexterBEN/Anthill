import java.nio.charset.Charset;
import java.util.Random;
import java.util.Scanner;

public class Application {
	

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
		mapManager.drawMap(map, w, h);
		
		//create queen set his params
		Queen q1 = new Queen(1, 1, Ant.setId());
		
		//generate queen children:
		Random randInt = new Random();
		int randomIndex = randInt.nextInt((2-1)+1) + 1;
		
		for(int i=0; i <= 2; i++) 
		{
			q1.ants.add(q1.giveBirth(randomIndex));
		}
		
		for(Ant children: q1.ants) 
		{
			int nb= 1;
			System.out.println(nb+" Child:"+children.id);
			nb++;
		}
		
		System.out.println();
		System.out.println();
		
		System.out.println("Reine posX:"+q1.x+" posY:"+q1.y+" id:"+q1.id);
		
		//update map with queen posX & Y then re-draw the map
		map[q1.x][q1.y] = "q1";
		System.out.println("Map after set queen position");
		mapManager.drawMap(map, w, h);
		
		
		

	}

}
