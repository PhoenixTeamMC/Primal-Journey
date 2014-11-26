package pheonixTeam.main.map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;

public class Tile{
	
	public static final Tile DESERT = new Tile("desert.png");
	public static final Tile ICE = new Tile("ice.png");
	public static final Tile WATER = new Tile("water.png");
	public static final Tile GRASS = new Tile("grass.png");
	public static final Tile DEFAULT = new Tile("tileBlank.png");
	
	public StaticTiledMapTile tile;
	
	public Tile(String texturePath){
		if(tile == null){
			tile = new StaticTiledMapTile(new TextureRegion(new Texture(texturePath)));
		}
	}
	
	public Tile setTile(int x, int y, TiledMapTileLayer layer){
		Cell cell = new Cell();
		
		cell.setTile(this.tile);
		
		layer.setCell(x, y, cell);
		
		return this;
	}

}
