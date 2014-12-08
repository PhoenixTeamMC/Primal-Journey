package phoenixTeam;

import phoenixTeam.entity.living.enemy.EntitySlime;
import phoenixTeam.entity.living.familiars.EntityChris;
import phoenixTeam.entity.living.familiars.EntityFamiliar;
import phoenixTeam.entity.living.player.EntityPlayer;
import phoenixTeam.map.Map;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.thoughtworks.xstream.XStream;

public class Main extends ApplicationAdapter{

	public static final XStream xml = new XStream();

	public Map currentMap;

	public OrthographicCamera camera;
	public SpriteBatch batch;
	public EntityPlayer player;
	public EntityFamiliar familiar;

	public FPSLogger log;
	
	@Override
	public void create () {
		char c = 7;
		
		System.out.println(c);
		
		//Setup the FPS Tracker
		log = new FPSLogger();
		
		//Setup the camera
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
        camera = new OrthographicCamera(100, 100 * (h/w));
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);    
        camera.update(); 
		
        //Setup the SpriteBatch for rendering Entities
        batch = new SpriteBatch();

        //Setup the Map.
		currentMap = new Map(100, 100);
		
		//Add the player to the map.
		player = new EntityPlayer(currentMap, camera);
		currentMap.spawnEntity(player);
		
		//Add the familiar
		familiar = new EntityChris(10, 10, currentMap, player);
		currentMap.spawnEntity(familiar);

		//Add a slime
		EntitySlime slime = new EntitySlime(10, 10);
		currentMap.spawnEntity(slime);
	}

	@Override
	public void render () {
		log.log();
		
		//Clear the screen
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		//Set the batch to adjust for the camera
		batch.setProjectionMatrix(camera.combined);
		
		//Tick the map
		currentMap.onTick();
		
		currentMap.display(camera, batch);
	}

	
}
