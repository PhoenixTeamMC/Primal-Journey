package phoenixTeam.map;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import phoenixTeam.util.Random;

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
	}

	public TiledMapTileLayer generate(){

		height.generate();
		moisture.generate();
		temperature.generate();

		for(int i = 0; i < xSize; i++){
			for(int g = 0; g < ySize; g++){
				getTile(i,g).setTile(g, i, layer);
			}
		}

		return layer;
	}
	
	private Tile getTile(int x, int y){

		int height = this.height.get(x, y);
		int moisture = this.moisture.get(x, y);
		int temperature = this.temperature.get(x, y);


		return Tile.getTile(height, moisture, temperature);
	}

}
