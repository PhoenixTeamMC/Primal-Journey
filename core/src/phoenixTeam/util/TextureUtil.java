package phoenixTeam.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureUtil {
	
	public static Texture getTexture(String name){
		System.out.println(Gdx.files.internal(name).file().getAbsolutePath());
		return new Texture(Gdx.files.internal("data/" + name));
	}

}
