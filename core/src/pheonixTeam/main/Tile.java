package pheonixTeam.main;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tile {

	Texture texture;
	
	SpriteBatch batch;
	
	public final int x;
	public final int y;
	
	public Tile(int x, int y){
		this.x = x;
		this.y = y;
		
		batch = new SpriteBatch();
	}
	
	public String getTexturePath(){
		return "assets/tileBlank.png";
	}
	
	public void display() {
		batch.begin();
		
		batch.draw(texture, x, y);
		
		batch.end();
	}

}
