package phoenixTeam.map;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import phoenixTeam.PrimalJourney;

import java.util.ArrayList;
import java.util.List;

public class Tile{
	
	
	public static List<Tile> tileList = new ArrayList<Tile>();
	
	//Height goes from -50 to 100, with 0 being the border between Sea and Land
	//Temperature goes from -25 to 100, with 0 being water freezing
	//Moisture goes from 0 to 100
	//Constructor goes height, temp, moisture
	
	//Height -> Temp -> Moisture
	
	//Height 90-100 - Ice Cap 
	public static final Tile ICE_CAP = new Tile("ice", 90, 100, -25, 100, 0, 100);
	
	//Height 80-90 - Mountains
	public static final Tile MOUNTAIN = new Tile("desert", 80, 90, -25, 100, 0, 100);
	
	//Height 50-80 - Various Hills
	public static final Tile DESERT_DUNES = new Tile("desert",    50, 80, 25 , 100, 0 , 25 );
	public static final Tile SAVANNAH_HILLS = new Tile("grass",   50, 80, 75 , 100, 25, 50 ); 
	public static final Tile TROPICAL_FOREST = new Tile("grass",  50, 80, 75 , 100, 50, 75 );
	public static final Tile RAINFOREST_HILLS = new Tile("grass", 50, 80, 50 , 100, 75, 100);
	public static final Tile GRASSY_HILLS = new Tile("grass",     50, 80, 25 , 75 , 25, 50 );
	public static final Tile FOREST_HILLS = new Tile("grass",     50, 80, 25 , 75 , 50, 75 );
	public static final Tile TAIGA_HILLS = new Tile("ice",        50, 80, 0  , 50 , 0 , 100);
	public static final Tile TUNDRA_HILLS = new Tile("ice",       50, 80, -50, 0  , 0 , 100);
	
	
	
	//Height 0-50 - Plains, etc
	public static final Tile DESERT = new Tile("desert",    0 , 50, 25 , 100, 0 , 25 );
	public static final Tile SAVANNAH = new Tile("grass",   0 , 50, 75 , 100, 25, 50 ); 
	public static final Tile TROPICAL = new Tile("grass",   0 , 50, 75 , 100, 50, 75 );
	public static final Tile RAINFOREST = new Tile("grass", 0 , 50, 50 , 100, 75, 100);
	public static final Tile GRASSY = new Tile("grass",     0 , 50, 25 , 75 , 25, 50 );
	public static final Tile FOREST = new Tile("grass",     0 , 50, 25 , 75 , 50, 75 );
	public static final Tile TAIGA = new Tile("ice",        0 , 50, 0  , 50 , 0 , 100);
	public static final Tile TUNDRA = new Tile("ice",       0 , 50, -50, 0  , 0 , 100);
	
	//Height -50-0 - Underwater
	public static final Tile ICE = new Tile("ice", -50, 0, -25, 0, 10, 100);
	public static final Tile WATER = new Tile("water", -50, 0, 0, 100, 10, 100);
	
	public static final Tile DRY_SEABED = new Tile("grass", -50, 0, -25, 100, 0, 10);
	
	
	public static final Tile DEFAULT;
	static{
		 DEFAULT = new Tile("tileBlank", -50, 100, -25, 100, 0, 100);
		 tileList.remove(DEFAULT);
	}
	
	public StaticTiledMapTile tile;
	
	int heightMax;
	int temperatureMax;
	int moistureMax;
	
	int heightMin;
	int temperatureMin;
	int moistureMin;
	
	String location;
	
	public Tile(String location, int heightMin, int heightMax, int temperatureMin, int temperatureMax, int moistureMin, int moistureMax){
		tile = new StaticTiledMapTile(PrimalJourney.assetManager.get("data/terrain/pack/terrain.atlas", TextureAtlas.class).findRegion(location));
		
		this.location = location;
		
		this.heightMax = heightMax;
		this.heightMin = heightMin;
		
		this.temperatureMax = temperatureMax;
		this.temperatureMin = temperatureMin;
		
		this.moistureMin = moistureMin;
		this.moistureMax = moistureMax;
		
		tileList.add(this);
	}
	
	public Tile setTile(int x, int y, TiledMapTileLayer layer, Biome biome){
		CellStorage cell = new CellStorage();
		
		cell.setTile(this.tile);
		cell.biome = biome;
		
		layer.setCell(x, y, cell);
		
		return this;
	}
	
	public static Tile getTile(int height, int moisture, int temperature) {
		
		for(Tile tile : tileList){
			
			boolean isTile = true;
			
			if(!(tile.heightMax >= height && tile.heightMin <= height)){
				isTile = false;
			}
			
			if(!(tile.temperatureMax >= temperature && tile.temperatureMin <= temperature)){
				isTile = false;
			}
			
			if(!(tile.moistureMax >= moisture && tile.moistureMin <= moisture)){
				isTile = false;
			}
			
			if(isTile){
				return tile;
			}
		}
		
		return DEFAULT;
	}
	
	@Override
	public String toString(){
		return location;
	}

}
