package pheonixTeam.main.map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;

public class Tile{
	
	public StaticTiledMapTile tile;
	
	public Tile(){
		if(tile == null){
			tile = new StaticTiledMapTile(new TextureRegion(new Texture(getTexturePath())));
		}
	}
	
	public TiledMapTile getTile(){
		return tile;
	}
	
	public String getTexturePath(){
		return "tileBlank.png";
	}

}
