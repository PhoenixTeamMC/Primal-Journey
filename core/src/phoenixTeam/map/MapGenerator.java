package phoenixTeam.map;


import phoenixTeam.util.Random;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public class MapGenerator {

	private static final int chunkSize = 16;
	
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

		if(this.xSize % chunkSize != 0){
			throw new IllegalArgumentException("X Size must divisible by the chunk size:" + chunkSize);
		}
		
		if(this.ySize % chunkSize != 0){
			throw new IllegalArgumentException("Y Size must divisible by the chunk size:" + chunkSize);
		}
		
		height = new Layer(xSize,ySize).setMin(-50).setMax(100).setChange(5);
		moisture = new Layer(xSize, ySize).setMin(0).setMax(100).setChange(5);
		temperature = new Layer(xSize, ySize).setMin(-25).setMax(100).setChange(5);

		calculateInterval();
	}

	public TiledMapTileLayer generate(){

		generateLayer(height);
		generateLayer(moisture);
		generateLayer(temperature);

		for(int i = 0; i < xSize; i++){
			for(int g = 0; g < ySize; g++){
				getTile(i,g).setTile(g, i, layer);
			}
		}

		return layer;
	}

	private void generateLayer(Layer layer){
		for(int i = 0; i < this.xSize; i += chunkSize){
			for(int g = 0; g < this.ySize; g += chunkSize){
				this.generateSection(layer, i, g, chunkSize);
			}
		}
	}

	private void generateSection(Layer layer, int startX, int startY, int width){

		int endY = startY + width;
		int endX = startX + width;
		
		int x = random.nextInt(startX, endX);
		int y = random.nextInt(startY, endY);
		
		
		
		layer.startGeneration(x, y);
		
		//Upper Left Quadrant
		for(int i = startX; i < x; i++){
			for(int g = startX; g < y; g++){
				layer.generate(i,g);
			}
		}

		//Upper Right Quadrant
		for(int i = x; i < endX; i++){
			for(int g = startX; g < y; g++){
				layer.generate(i,g);
			}
		}

		//Lower Left Quadrant
		for(int i = startX; i < x; i++){
			for(int g = y; g < endY; g++){
				layer.generate(i,g);
			}
		}

		//Lower Right Quadrant
		for(int i = x; i < endX; i++){
			for(int g = y; g < endY; g++){
				layer.generate(i,g);
			}
		}
	}
	
	private Tile getTile(int x, int y){

		int height = this.height.get(x, y);
		int moisture = this.moisture.get(x, y);
		int temperature = this.temperature.get(x, y);


		return Tile.getTile(height, moisture, temperature);
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

}
