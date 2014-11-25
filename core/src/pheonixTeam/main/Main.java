package pheonixTeam.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.thoughtworks.xstream.XStream;

public class Main extends ApplicationAdapter {
	
	public static final XStream xml = new XStream();
	
	Map map;
	
	@Override
	public void create () {
		map = new Map(100, 100);
        
        
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);                        // #14
        
		map.display();
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
