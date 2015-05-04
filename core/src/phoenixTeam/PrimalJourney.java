package phoenixTeam;

import phoenixTeam.event.input.InputHandler;
import phoenixTeam.screen.LoadingScreen;
import phoenixTeam.util.GifLoader;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Json;
import com.google.common.eventbus.EventBus;

/**
 * @author chbachman
 *
 */
public class PrimalJourney extends Game{

	//An instance of this, for easy access
    public static PrimalJourney INSTANCE;

    //The batch for rendering most of the game.
	public static SpriteBatch batch;
	
	//The asset manager, for loading most assets.
	public static AssetManager assetManager;
	
	//The engine, for handling most portions of the game.
	public static Engine engine;
	
	//The camera, for rendering most parts of in-game;
	public static OrthographicCamera camera;
	
	//The inputHandler, with the Input event already registered.
	public static InputMultiplexer inputHandler;
	
	//The eventbus that this is all posted to.
	public static EventBus bus;
	
	//Stage, for guis.
	public static Stage stage;
	
	//Json, for reading and writing to disk. We don't even have to worry about where.
	public static Json json;
	
	//The FPS logger
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

		camera = new OrthographicCamera(400, 400 * (h/w));
		camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);    
		camera.update(); 
		
		//Setup the engine
		engine = new Engine();
		
		//Setup the assetManager, and add the GifLoader
		assetManager = new AssetManager();
		assetManager.setLoader(Animation.class, new GifLoader(new InternalFileHandleResolver()));
		
		this.setScreen(new LoadingScreen());
		
		//Setup the InputHandlers
		inputHandler = new InputMultiplexer();
		Gdx.input.setInputProcessor(inputHandler);
		inputHandler.addProcessor(new InputHandler());
		
		//Setup the SpriteBatch
		batch = new SpriteBatch();
		
		//Setup the FPS Tracker
		log = new FPSLogger();
		
		//Setup the eventbus.
		bus = new EventBus();
		
		//Setup the Json Serializer
		json = new Json();
		
		//Setup the stage, for gui work.
		stage = new Stage();
		
		//this.setScreen(new MapScreen());
	}

	/**
	 * This is for rendering things that do not depend on what screen we are in.
	 */
	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();
		//log.log();
		//assetManager.update();
		engine.update(Gdx.graphics.getDeltaTime());
		stage.draw();

	}
	
	@Override
	public void dispose(){
		super.dispose();
		
		stage.dispose();
		assetManager.dispose();
		batch.dispose();
	}
	
}
