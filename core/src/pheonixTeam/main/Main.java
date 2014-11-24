package pheonixTeam.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.thoughtworks.xstream.XStream;

public class Main extends ApplicationAdapter {
	
	public static final XStream xml = new XStream();
	
	private static final int FRAME_COLS = 6;
    private static final int FRAME_ROWS = 5;
	
	Animation animation;
	SpriteBatch batch;
	Texture img;
	TextureRegion[] walkFrames;
	TextureRegion current;
	
	float stateTime;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
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
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);                        // #14
        stateTime += Gdx.graphics.getDeltaTime(); 
        
        current = animation.getKeyFrame(stateTime, true);
        
		batch.begin();
		batch.draw(current, 50, 50, 300, 300);
		batch.end();
	}
}
