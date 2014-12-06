package phoenixTeam.map;


import java.util.ArrayList;
import java.util.List;

import phoenixTeam.map.Tile.Levels;
import phoenixTeam.util.Random;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public class MapGenerator {

	private TiledMapTileLayer layer;

	private final int xSize;
	private final int ySize;

	Layer height;
	Layer moisture;
	Layer temperature;

	Random random = new Random();

	public MapGenerator(TiledMapTileLayer layer){
		this.layer = layer;

		this.xSize = layer.getWidth();
		this.ySize = layer.getHeight();

		height = new Layer(xSize,ySize).setMin(-50).setMax(50).setChange(5);
		moisture = new Layer(xSize, ySize).setMin(-50).setMax(50).setChange(5);
		temperature = new Layer(xSize, ySize).setMin(-50).setMax(50).setChange(5);

		calculateInterval();
	}

	public TiledMapTileLayer generate(){

		int x = random.nextInt(xSize);
		int y = random.nextInt(ySize);

		generateLayer(height, x,y);
		generateLayer(moisture, x, y);
		generateLayer(temperature,x,y);

		for(int i = 0; i < xSize; i++){
			for(int g = 0; g < ySize; g++){
				getTile(i,g).setTile(g, i, layer);
			}
		}

		return layer;
	}

	private void generateLayer(Layer layer, int x, int y){

		layer.startGeneration(x, y);

		//Upper Left Quadrant
		for(int i = 0; i < x; i++){
			for(int g = 0; g < y; g++){
				layer.generate(i,g);
			}
		}

		//Upper Right Quadrant
		for(int i = x; i < xSize; i++){
			for(int g = 0; g < y; g++){
				layer.generate(i,g);
			}
		}

		//Lower Left Quadrant
		for(int i = 0; i < x; i++){
			for(int g = y; g < ySize; g++){
				layer.generate(i,g);
			}
		}

		//Lower Right Quadrant
		for(int i = x; i < xSize; i++){
			for(int g = y; g < ySize; g++){
				layer.generate(i,g);
			}
		}
	}

	private Tile getTile(int x, int y){

		int height = this.height.get(x, y);
		int moisture = this.height.get(x, y);
		int temperature = this.height.get(x, y);


		List<Tile> tiles = this.getTiles(height, moisture, temperature);
		
		return random.pickRandom(tiles);
	}

	private int[] heightMap;
	private int[] moistureMap;
	private int[] temperatureMap;

	private void calculateInterval() {

		heightMap = new int[4];

		int heightInterval = (this.height.max - this.height.min) / 3;

		heightMap[0] = this.height.min;

		for(int i = 1; i < heightMap.length; i++){
			heightMap[i] = heightMap[i - 1] + heightInterval;
		}

		moistureMap = new int[4];

		int moistureInterval = (this.moisture.max - this.moisture.min) / 3;

		moistureMap[0] = this.moisture.min;

		for(int i = 1; i < moistureMap.length; i++){
			moistureMap[i] = moistureMap[i - 1] + moistureInterval;
		}

		temperatureMap = new int[4];

		int temperatureInterval = (this.temperature.max - this.temperature.min) / 3;

		temperatureMap[0] = this.temperature.min;

		for(int i = 1; i < temperatureMap.length; i++){
			temperatureMap[i] = temperatureMap[i - 1] + temperatureInterval;
		}

	}

	public List<Tile> getTiles(int height, int moisture, int temperature){
		List<Tile> output = new ArrayList<Tile>();
		List<Tile> tileList = Tile.tileList;

		for(Tile tile : tileList){
			
			boolean shouldUse = false;
			
			if(isWithin(height, tile.height, heightMap)){
				shouldUse = true;
			}
			
			if(isWithin(moisture, tile.moisture, moistureMap)){
				shouldUse = true;
			}
			
			if(isWithin(temperature, tile.temperature, temperatureMap)){
				shouldUse = true;
			}
			
			if(shouldUse){
				output.add(tile);
			}
			
		}

		return output;
	}

	private static boolean isWithin(int tile, Levels level, int[] map){
		if(level == Levels.ANY){
			return true;
		}
		
		int counter = 0;
		
		for(int data : map){
			
			if(data > tile){
				 switch(counter){
				 
				 case 0: return false;
				 case 1: return level == Levels.LOW;
				 case 2: return level == Levels.MIDDLE;
				 case 3: return level == Levels.HIGH;
				 
				 }
			}
			
		}
		
		return false;
		
	}

}
