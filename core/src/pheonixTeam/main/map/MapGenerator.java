package pheonixTeam.main.map;


import pheonixTeam.main.util.Random;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public class MapGenerator {
	
	private TiledMapTileLayer layer;
	
	private final int xSize;
	private final int ySize;
	
	Layer height;
	
	Random random = new Random();
	
	public MapGenerator(TiledMapTileLayer layer){
		this.layer = layer;
		
		this.xSize = layer.getWidth();
		this.ySize = layer.getHeight();
		
		height = new Layer(xSize,ySize);
	}
	
	public TiledMapTileLayer generate(){
		
		int x = random.nextInt(xSize);
		int y = random.nextInt(ySize);
		
		height.startGeneration(x, y);

		//Upper Left Quadrant
		for(int i = 0; i < x; i++){
			for(int g = 0; g < y; g++){
				height.generate(i,g);
			}
		}
		
		//Upper Right Quadrant
		for(int i = x; i < xSize; i++){
			for(int g = 0; g < y; g++){
				height.generate(i,g);
			}
		}
		
		//Lower Left Quadrant
		for(int i = 0; i < x; i++){
			for(int g = y; g < ySize; g++){
				height.generate(i,g);
			}
		}
		
		//Lower Right Quadrant
		for(int i = x; i < xSize; i++){
			for(int g = y; g < ySize; g++){
				height.generate(i,g);
			}
		}

		for(int i = 0; i < xSize; i++){
			for(int g = 0; g < ySize; g++){
				getTile(height.get(i, g)).setTile(g, i, layer);
			}
		}

		return layer;
	}
	
	private static Tile getTile(int height){
		if(height > 50){
			return Tile.DESERT; //Will be mountain.
		}else if(height > 20){
			return Tile.DESERT; //Will be hill
		}else if(height > 0){
			return Tile.GRASS;
		}else if(height > -10){
			return Tile.GRASS;
		}else if(height >= -30){
			return Tile.WATER; //Will be deep ocean
		}else if(height >= -50){
			return Tile.WATER;
		}
		
		return Tile.DEFAULT; // Should never happen
	}

}
