import java.util.Scanner;

public class Application {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String [][] map = new String[24][24];
		Scanner sc = new Scanner(System.in);
		MapManager map = MapManager.getInstance();
		
		System.out.print("Give map width: ");
		String width = sc.nextLine();
		
		System.out.print("Give map height: ");
		String height = sc.nextLine();
		
		System.out.println(width);
		System.out.println(height);
		System.out.println();
		System.out.println();
		
		int w = Integer.parseInt(width);
		int h = Integer.parseInt(height);
		
		map.width = w;
		map.height = h;
		
		MapManager.drawMap(map);
		
		

	}

}
