package pheonixTeam.main;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tile {
	
	static Texture texture;
	
	public final int x;
	public final int y;
	
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
	
	public void display(SpriteBatch batch) {
		batch.draw(texture, x, y, 1, 1);
	}

}
