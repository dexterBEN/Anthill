package utils;

import com.sun.javafx.collections.MapAdapterChange;

import entities.Ant;
import entities.Fighter;
import entities.Worker;

public class MapManager {

    int width, height;
    static String[][] map;
    private static final MapManager singletonInstance;

    static {
        singletonInstance = new MapManager();
    }

    private MapManager() {}

    public static MapManager getInstance() {
        return singletonInstance;
    }

    public static String[][] initMap(int width, int height) {
        map = new String[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if ((i > 0 && i < (width - 1)) && (j > 0 && j < (height - 1))) {
                    map[i][j] = "  ";
                } else {
                    map[i][j] = "* ";
                }
            }
        }

        return map;
    }

    public static void drawMap(String map[][], int w, int h) {

        for (int i = 0; i < w; i++) {

            for (int j = 0; j < h; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public static String printAntOnMap(Ant ant) {
        String antBadge = "";
        if (ant instanceof Worker) {
            antBadge = "w ";
        } else if (ant instanceof Fighter) {
            antBadge = "f ";
        }

        return ant.getBadge();

    }

    public static boolean isEmpty(String map[][], int x, int y) {
        return map[x][y] == "";
    }

}
