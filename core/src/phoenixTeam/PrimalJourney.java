package phoenixTeam;

import phoenixTeam.event.input.InputHandler;
import phoenixTeam.map.MapScreen;
import phoenixTeam.util.GifLoader;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.thoughtworks.xstream.XStream;

/**
 * @author chbachman
 *
 */
public class PrimalJourney extends Game{

    public static PrimalJourney INSTANCE;
	public static final XStream xml = new XStream();

	public static SpriteBatch batch;
	public static AssetManager manager;

	public FPSLogger log;
	
	/**
	 * This is for creating things that do not depend on what screen we are currently in. 
	 */
	@Override
	public void create () {
		manager = new AssetManager();
		INSTANCE = this;
		manager.setLoader(Animation.class, new GifLoader(new InternalFileHandleResolver()));
		
		batch = new SpriteBatch();
		
		//Setup the FPS Tracker
		log = new FPSLogger();
		
		//Init the InputHandler
		InputHandler.init();
		
		this.setScreen(new MapScreen());
	}

	/**
	 * This is for rendering things that do not depend on what screen we are in.
	 */
	@Override
	public void render () {
		log.log();
		
		//Clear the screen
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		super.render();
	}
	
}
