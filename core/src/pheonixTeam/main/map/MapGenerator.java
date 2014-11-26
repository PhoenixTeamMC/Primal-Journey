package pheonixTeam.main.map;


import java.util.ArrayList;
import java.util.List;

import pheonixTeam.main.util.Random;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public class MapGenerator {
	
	private TiledMapTileLayer layer;
	
	private final int xSize;
	private final int ySize;
	
	private final Random random = new Random();
	
	private final int heightMin = -50;
	private final int heightMax = 50;
	
	private final int heightDifference = 1;
	
	int[][] heightTable;
	boolean[][] hasBeenDone;
	
	int intialx = 0;
	int intialy = 0;
	
	public MapGenerator(TiledMapTileLayer layer){
		this.layer = layer;
		
		this.xSize = layer.getWidth();
		this.ySize = layer.getHeight();
		
		heightTable = new int[xSize][ySize];
		hasBeenDone = new boolean[xSize][ySize];
	}
	
	public TiledMapTileLayer generate(){
		startGeneration();
		
		for(int x = 0; x < heightTable.length; x++){
			for(int y = 0; y < heightTable[x].length; y++){
				getTileForHeight(heightTable[x][y]).setTile(x, y, layer);
			}
		}
		
		return layer;
	}
	
	private void startGeneration(){
		int x = xSize / 2;
		int y = ySize / 2;
		
		System.out.println(String.format("x: %s, y: %s", x, y));
		
		int height = random.nextInt(random.variance(20, 20));
		
		heightTable[x][y] = height;
		hasBeenDone[x][y] = true;
		
		generate(x + 1, y);
		generate(x - 1, y);
		generate(x, y + 1);
		generate(x, y - 1);
	}
	
	private void generate(int x, int y){
		
		if(!isValid(x,y) || hasBeenDone[x][y]){
			return;
		}else{
			
			int average = averageOfAllAround(heightTable, x, y);
			
			int newHeight = random.variance(average, heightDifference);
			
			if(newHeight > 50){
				newHeight = 50;
			}else if(newHeight < -50){
				newHeight = -50;
			}
			
			
			
			heightTable[x][y] = newHeight;
			hasBeenDone[x][y] = true;
			
			generate(x + 1, y);
			generate(x - 1, y);
			generate(x, y + 1);
			generate(x, y - 1);
		}
	}
	
	private int averageOfAllAround(int[][] array, int x, int y){
		int up = isValid(x,y + 1) ? array[x][y + 1] : 0;
		int down = isValid(x,y - 1) ? array[x][y - 1] : 0;
		int left = isValid(x - 1,y) ? array[x - 1][y] : 0;
		int right = isValid(x + 1,y) ? array[x + 1][y] : 0;
		
		List<Integer> list = new ArrayList<Integer>(4);
		
		if(up != 0){
			list.add(up);
		}
		
		if(down != 0){
			list.add(down);
		}
		
		if(left != 0){
			list.add(left);
		}
		
		if(right != 0){
			list.add(right);
		}
		
		return average(list.toArray(new Integer[0]));
	}
	
	private static int average(Integer... ints){
		
		if(ints.length == 0){
			return 0;
		}
		
		int sum = 0;
		for(int i : ints){
			sum += i;
		}
		
		return sum / ints.length;
	}
	
	private boolean isValid(int x, int y){
		return x >= 0 && x < xSize && y >= 0 && y < ySize;
	}
	
	private static Tile getTileForHeight(int height){
		if(height > 50){
			return Tile.DESERT; //Will be mountain.
		}else if(height > 20){
			return Tile.DESERT; //Will be hill
		}else if(height > 0){
			return Tile.GRASS;
		}else if(height > -20){
			return Tile.WATER;
		}else if(height > -50){
			return Tile.ICE; //Will be deep ocean
		}
		
		return Tile.DEFAULT; // Should never happen
	}

}
