package pheonixTeam.main.map;


import pheonixTeam.main.util.Random;

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
		
		//TODO: Implement This. 
		
		return Tile.GRASS;
	}

}
