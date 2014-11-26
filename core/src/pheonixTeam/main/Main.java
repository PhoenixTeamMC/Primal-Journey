package pheonixTeam.main;

import pheonixTeam.main.entity.living.EntityPlayer;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.thoughtworks.xstream.XStream;

public class Main extends ApplicationAdapter{
	
	public static final XStream xml = new XStream();
	
	public Map currentMap;
	
	OrthographicCamera camera;
	SpriteBatch batch;
	
	@Override
	public void create () {
		
		float w = Gdx.graphics.getWidth();                                      
        float h = Gdx.graphics.getHeight();                                      
        camera = new OrthographicCamera(100, 100 * (h / w));                          
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);    
        camera.update(); 
		
        batch = new SpriteBatch();
        
		currentMap = new Map(100, 100);
		currentMap.spawnEntity(new EntityPlayer());
		
	}

	@Override
	public void render () {
		
		
		
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		currentMap.onTick();
		
		
		currentMap.display(camera, batch);
		
		System.out.println(Gdx.graphics.getFramesPerSecond());
		
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
