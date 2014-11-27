package pheonixTeam.main;

import pheonixTeam.main.entity.living.familiars.EntityChris;
import pheonixTeam.main.entity.living.familiars.EntityFamiliar;
import pheonixTeam.main.entity.living.player.EntityPlayer;
import pheonixTeam.main.map.Map;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
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

	@Override
	public void create () {
		//Setup the camera
        camera = new OrthographicCamera(100, 100 * (Gdx.graphics.getHeight() / Gdx.graphics.getWidth()));                          
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);    
        camera.update(); 
		
        //Setup the SpriteBatch for rendering Entities
        batch = new SpriteBatch();

        //Setup the Map.
		currentMap = new Map(2000, 2000);
		
		//Add the player to the map.
		player = new EntityPlayer(currentMap, camera);
		currentMap.spawnEntity(player);
		
		//Add the familiar
		familiar = new EntityChris(player);
		familiar.x = 10;
		familiar.y = 10;
		currentMap.spawnEntity(familiar);
	}

	@Override
	public void render () {
		//Clear the screen
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		//Set the batch to adjust for the camera
		batch.setProjectionMatrix(camera.combined);
		
		//Tick the map
		currentMap.onTick();
		
		currentMap.display(camera, batch);
	}
	
	
	
	/*
	 * Animation Code:
	 * batch = new SpriteBatch();
		img = new Texture("animation.png");
		TextureRegion[][] tmp = TextureRegion.split(img, img.getWidth()/FRAME_COLS, img.getHeight()/FRAME_ROWS);
		
		walkFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS]; 
		
		int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                walkFrames[index++] = tmp[i][j];
            }
        }
        
        animation = new Animation(.025f, walkFrames);
        
        stateTime = 0f;
        
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);                        // #14
        stateTime += Gdx.graphics.getDeltaTime(); 
        
        current = animation.getKeyFrame(stateTime, true);
        
		batch.begin();
		batch.draw(current, 50, 50, 300, 300);
		batch.end();
	 */
}
