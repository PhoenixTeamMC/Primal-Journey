package pheonixTeam.main.map;


import pheonixTeam.main.util.Random;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public class MapGenerator {
	
	private TiledMapTileLayer layer;
	
	private final int xSize;
	private final int ySize;
	
	private final Random random = new Random();
	
	Layer height;
	
	public MapGenerator(TiledMapTileLayer layer){
		this.layer = layer;
		
		this.xSize = layer.getWidth();
		this.ySize = layer.getHeight();
		
		height = new Layer(xSize,ySize);
	}
	
	public TiledMapTileLayer generate(){
		startGeneration();
		
		for(int x = 0; x < layer.getWidth(); x++){
			for(int y = 0; y < layer.getHeight(); y++){
				getTile(height.get(x, y)).setTile(y, x, layer);
			}
		}
		
		return layer;
	}
	
	private void startGeneration(){
		int x = random.nextInt(xSize);
		int y = random.nextInt(ySize);
		
		int currHeight = 10;
		
		height.set(x, y, currHeight);
		
		for(int i = 0; i < xSize; i++){
			for(int g = 0; g < ySize; g++){
				height.generate(x,y);
			}
		}
	}
	
	private static Tile getTile(int height){
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
