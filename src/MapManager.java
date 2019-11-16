
public class MapManager {
	
	int width, height;
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
	
	public static void drawMap(MapManager map) {
		for(int i = 1; i <= map.width; i++) 
		{
			
			for(int j = 1; j <= map.height; j++) 
			{
				if (i == 1 || i == map.width)
                    System.out.print("* ");
                else if (j == 1 || j == map.height)
                    System.out.print("* ");
                else
                    System.out.print("  ");
			}
			System.out.println();
		}
	}

}
