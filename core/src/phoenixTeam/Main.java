package phoenixTeam;

import phoenixTeam.event.input.InputHandler;
import phoenixTeam.map.MapScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.thoughtworks.xstream.XStream;

/**
 * @author chbachman
 *
 */
public class Main extends Game{

	public static final XStream xml = new XStream();

	public static final SpriteBatch batch = new SpriteBatch();

	public FPSLogger log;
	
	/**
	 * This is for creating things that do not depend on what screen we are currently in. 
	 */
	@Override
	public void create () {
		
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
