package phoenixTeam.map;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.MathUtils;

public class Biome{
	
	String texturePackName;
	
	Tile tileType;
	
	public Biome(Tile tile){
		this.tileType = tile;
	}
	
	public void generate(TiledMapTileLayer layer, int startX, int startY){
		
		generateHelper(layer, startX, startY, 1, 0);
		
	}
	
	private int size = MathUtils.random(10, 30);
	private int limit = 5;
	
	private void generateHelper(TiledMapTileLayer layer, int startX, int startY, int chance, int amountOfTaken){
		
		if(layer.getCell(startX, startY) == null){
			return;
		}
		
		if(amountOfTaken >= limit){
			return;
		}
		
		if(layer.getCell(startX, startY).getTile() != tileType.tile){
			tileType.setTile(startX, startY, layer, this);
		}else{
			amountOfTaken++;
		}
		
		if(MathUtils.random.nextInt(chance) < size){
			generateHelper(layer, startX + 1, startY, chance + 1, amountOfTaken);
		}
		
		if(MathUtils.random.nextInt(chance) < size){
			generateHelper(layer, startX - 1, startY, chance + 1, amountOfTaken);
		}
		
		if(MathUtils.random.nextInt(chance) < size){
			generateHelper(layer, startX, startY - 1, chance + 1, amountOfTaken);
		}
		
		if(MathUtils.random.nextInt(chance) < size){
			generateHelper(layer, startX, startY + 1, chance + 1, amountOfTaken);
		}
		
	}

}
