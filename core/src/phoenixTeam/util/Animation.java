package phoenixTeam.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Animation {
	
	final TextureRegion[] frames;
	final com.badlogic.gdx.graphics.g2d.Animation animation;
	
	int stateTime;
	TextureRegion current;
	
	public Animation(Texture texture, final int FRAME_COLS, final int FRAME_ROWS, float time){
		frames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
		
		TextureRegion[][] tmp = TextureRegion.split(texture, texture.getWidth()/FRAME_COLS, texture.getHeight()/FRAME_ROWS);
		
		int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                frames[index++] = tmp[i][j];
            }
        }
        
        animation = new com.badlogic.gdx.graphics.g2d.Animation(time, frames);
	}
	
	public void display(Batch batch, int x, int y, int width, int height){
		stateTime += Gdx.graphics.getDeltaTime();
		
		current = animation.getKeyFrame(stateTime, true);
		
		batch.draw(current,x,y,width,height);
	}
	
	/*
	 * Animation Code:
	 * batch = new SpriteBatch();
        
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
