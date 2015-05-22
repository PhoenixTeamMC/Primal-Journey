/* Copyright by Johannes Borchardt */
/* LibGdx conversion 2014 by Anton Persson */
/* Released under Apache 2.0 */
/* https://code.google.com/p/animated-gifs-in-android/ */

package phoenixTeam.util.specific;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.TextureLoader;
import com.badlogic.gdx.assets.loaders.TextureLoader.TextureParameter;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.Texture.TextureWrap;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class AnimationLoader extends AsynchronousAssetLoader<Animation, AnimationLoader.AnimationParameters>{

	TextureLoader l;

	public AnimationLoader(FileHandleResolver resolver) {
		super(resolver);
		l = new TextureLoader(resolver);
	}

	@Override
	public void loadAsync(AssetManager manager, String fileName, FileHandle file, AnimationParameters parameter){
		l.loadAsync(manager, fileName, file, createParameters(parameter));
	}

	@Override
	public Animation loadSync(AssetManager manager, String fileName, FileHandle file, AnimationParameters parameter){

		Texture sheet = l.loadSync(manager, fileName, file, createParameters(parameter));
		
		if(sheet == null){
			return null;
		}

		TextureRegion[][] tmp = TextureRegion.split(sheet, sheet.getWidth() / parameter.columns, sheet.getHeight() / parameter.rows);
		TextureRegion[] walkFrames = new TextureRegion[parameter.columns * parameter.rows];
		
		int index = 0;
		
		for (int i = 0; i < parameter.rows; i++){
			for (int j = 0; j < parameter.columns; j++){
				walkFrames[index++] = tmp[i][j];
			}
		}
		
		return new Animation(0.025f, walkFrames);
	}

	@Override
	public Array<AssetDescriptor> getDependencies(String fileName, FileHandle file, AnimationParameters parameter){
		return l.getDependencies(fileName, file, createParameters(parameter));
	}

	static TextureParameter createParameters(AnimationParameters g){
		TextureParameter p = new TextureParameter();

		p.format = g.format;
		p.genMipMaps = g.genMipMaps;
		p.texture = g.texture;
		p.textureData = g.textureData;
		p.minFilter = g.minFilter;
		p.magFilter = g.magFilter;
		p.wrapU = g.wrapU;
		p.wrapV = g.wrapV;

		return p;
	}

	public static class AnimationParameters extends AssetLoaderParameters<Animation>{
		
		public AnimationParameters(int rows, int columns){
			this.rows = rows;
			this.columns = columns;
		}
		
		int columns;
		int rows;
		
		/**
		 * the format of the final Texture. Uses the source images format if
		 * null
		 **/
		public Format format = null;
		/** whether to generate mipmaps **/
		public boolean genMipMaps = false;
		/** The texture to put the {@link TextureData} in, optional. **/
		public Texture texture = null;
		/**
		 * TextureData for textures created on the fly, optional. When set, all
		 * format and genMipMaps are ignored
		 */
		public TextureData textureData = null;
		public TextureFilter minFilter = TextureFilter.Nearest;
		public TextureFilter magFilter = TextureFilter.Nearest;
		public TextureWrap wrapU = TextureWrap.ClampToEdge;
		public TextureWrap wrapV = TextureWrap.ClampToEdge;
	}

}
