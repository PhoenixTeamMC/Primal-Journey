package pheonixTeam.main;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tile {

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
		
		batch.draw(texture, (texture.getHeight() + 1) * x, (texture.getWidth() + 1) * y);
		
		batch.end();
	}

}
