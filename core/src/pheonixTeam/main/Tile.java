package pheonixTeam.main;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tile {

	private static final int TILE_SIZE = 16;
	
	static Texture texture;
	static SpriteBatch batch;
	
	public final int x;
	public final int y;
	
	static{
		batch = new SpriteBatch();
	}
	
	public Tile(int x, int y){
		this.x = x;
		this.y = y;
		
		if(texture == null){
			texture = new Texture(getTexturePath());
		}
	}
	
	public String getTexturePath(){
		return "tileBlank.png";
	}
	
	public void display() {
		batch.begin();
		
		batch.draw(texture, (TILE_SIZE + 1) * x, (TILE_SIZE + 1) * y, TILE_SIZE, TILE_SIZE);
		
		batch.end();
	}

}
