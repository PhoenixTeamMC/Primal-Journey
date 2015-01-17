package phoenixTeam;

import phoenixTeam.event.input.InputHandler;
import phoenixTeam.map.MapScreen;
import phoenixTeam.util.GifLoader;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
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
	public static AssetManager assetManager;
	public static Engine engine;
	public static OrthographicCamera camera;
	
	public FPSLogger log;
	
	/**
	 * This is for creating things that do not depend on what screen we are currently in. 
	 */
	@Override
	public void create () {
		INSTANCE = this;

		//Setup the camera
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();


		camera = new OrthographicCamera(100, 100 * (h/w));
		camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);    
		camera.update(); 

		engine = new Engine();
		
		//Setup the assetManager, and add the GifLoader
		assetManager = new AssetManager();
		assetManager.setLoader(Animation.class, new GifLoader(new InternalFileHandleResolver()));
		
		
		//Setup the SpriteBatch
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
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();
		log.log();
		assetManager.update();
		engine.update(Gdx.graphics.getDeltaTime());

	}
	
}
