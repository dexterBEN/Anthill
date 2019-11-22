package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;

import utils.MapManager;


import org.junit.jupiter.api.Test;

import entities.QueenChildren;
import entities.Queen;

class MapManagerTest {

	@Test
	void checkCoordinateIsEmpty() {
		
		MapManager mapManager = MapManager.getInstance();
		
		Queen q2 = (Queen) QueenChildren.createAnt(0);
		String [][] map = mapManager.initMap(8, 8); 
		//mapManager.printAntOnMap(q2);
		map[q2.x][q2.y] = "q2";

		//expected isEmpty to be true
		Assertions.assertTrue(MapManager.isEmpty(map, 1,1));
	}
	
	@Test
	void checkCoordinateIsFull() {
		
		MapManager mapManager = MapManager.getInstance();
		
		Queen q2 = (Queen) QueenChildren.createAnt(0);
		String [][] map = mapManager.initMap(8, 8); 
		//mapManager.printAntOnMap(q2);
		map[q2.x][q2.y] = "q2";

		//expected isEmpty to be false
		Assertions.assertFalse(MapManager.isEmpty(map, 0,0));
	}
}
