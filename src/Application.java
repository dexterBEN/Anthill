import utils.MapManager;

public class Application {
	
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_BLUE = "\u001B[34m";
	
	public static void main(String[] args) {
		MapManager mapManager = MapManager.getInstance();
		mapManager.initMap();
		
		for(int i = 0; i < mapManager.getHeight(); i++) {
			StringBuilder builder = new StringBuilder(ANSI_BLACK + "| "); 
			for(int j = 0; j < mapManager.getWidth(); j++) {
				builder.append(ANSI_RED + (mapManager.getMap()[i][j] != null ? mapManager.getMap()[i][j] : " "));
				builder.append(ANSI_BLACK + " | ");
			}
			System.out.println(builder);
		}


	}
}
