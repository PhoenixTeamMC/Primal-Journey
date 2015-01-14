package phoenixTeam.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureUtil {
	
	public static Texture getTexture(String name){
		return new Texture(Gdx.files.internal("data/" + name));
	}

}
