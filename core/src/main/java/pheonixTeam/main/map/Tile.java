package pheonixTeam.main.map;

import java.util.ArrayList;
import java.util.List;

import pheonixTeam.main.util.TextureUtil;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;

public class Tile{
	
	public static enum Levels{
		ANY,
		HIGH,
		LOW,
		MIDDLE;
	}
	
	
	public static List<Tile> tileList = new ArrayList<Tile>();
	
	public static final Tile DESERT = new Tile("desert.png",Levels.LOW,Levels.ANY, Levels.HIGH);
	public static final Tile ICE = new Tile("ice.png", Levels.HIGH, Levels.LOW, Levels.LOW);
	public static final Tile WATER = new Tile("water.png", Levels.HIGH, Levels.LOW, Levels.MIDDLE);
	public static final Tile GRASS = new Tile("grass.png", Levels.MIDDLE, Levels.MIDDLE, Levels.MIDDLE);
	
	public StaticTiledMapTile tile;
	
	public final Levels moisture;
	public final Levels height;
	public final Levels temperature;
	
	public Tile(String texturePath, Levels moisture, Levels height, Levels temperature){
		
		this.moisture = moisture;
		this.height = height;
		this.temperature = temperature;
		
		if(tile == null){
			tile = new StaticTiledMapTile(new TextureRegion(TextureUtil.getTexture(texturePath)));
		}
		
		tileList.add(this);
	}
	
	public Tile setTile(int x, int y, TiledMapTileLayer layer){
		Cell cell = new Cell();
		
		cell.setTile(this.tile);
		
		layer.setCell(x, y, cell);
		
		return this;
	}

}
