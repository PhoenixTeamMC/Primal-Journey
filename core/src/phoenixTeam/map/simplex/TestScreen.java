package phoenixTeam.map.simplex;

import phoenixTeam.PrimalJourney;
import phoenixTeam.map.MapGenerator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class TestScreen implements Screen, InputProcessor{

	private Texture map;
	OrthographicCamera camera;
	SpriteBatch batch = new SpriteBatch();
	
	@Override
	public void render(float delta){
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(camera.combined);

		batch.begin();
		batch.draw(map, 0, 0);
		batch.end();
	}	

	@Override
	public void resize(int width, int height){}

	@Override
	public void show(){
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		PrimalJourney.inputHandler.addProcessor(0, this);

		camera = new OrthographicCamera(1000, 1000 * (h / w)); //Setup Camera

		
		System.out.println("Creating Map.");
		long time = System.currentTimeMillis();
		MapGenerator m = new MapGenerator(); //Generate Map
		System.out.println(String.format("Done Creating Map. Took %s seconds.", (System.currentTimeMillis() - time) / 1000F));
		
		
		float[][] map = m.toRender;
		
		float min = min(map);
		float max = max(map);

		//System.out.println("min: " + min + ", max: " + max); //Get map max and min

		scale(map, 0, 1); //Scale the map to 0 and 1

		min = min(map);
		max = max(map);
		//System.out.println("min: " + min + ", max: " + max); //Get map max and min
		
		System.out.println("Creating Picture of Map.");
		time = System.currentTimeMillis();
		
		Pixmap pixmap = new Pixmap(map.length, map[0].length, Format.RGBA8888);
		
		pixmap.setColor(Color.RED);
		
		
		
		float v;
		for (int x = 0; x < map.length; x++){
			for (int y = 0; y < map[x].length; y++){
				v = (float) map[x][y];
				pixmap.setColor(m.colorPoints(x, y, map.length, map[x].length, v));
				pixmap.drawPixel(x, y);
			}
		}
		
		//pixmap.fillRectangle(0, 0, map.length, map[0].length);
		
		
		this.map = new Texture(pixmap);
		pixmap.dispose();
		
		System.out.println(String.format("Done Creating Picture of Map. Took %s seconds.", (System.currentTimeMillis() - time) / 1000F));
	}

	@Override
	public void hide(){}

	@Override
	public void pause(){}

	@Override
	public void resume(){}

	@Override
	public void dispose(){
		map.dispose();
	}

	public static float[][] scale(float[][] items, float min, float max){
		float tmp = amplitude2(items) / (max - min);

		for (float[] item : items){
			for (int i = 0; i < item.length; i++){
				item[i] /= tmp;
			}
		}

		tmp = min - min(items);

		for (float[] item : items){
			for (int i = 0; i < item.length; i++){
				item[i] += tmp;
			}
		}

		return items;
	}

	public static float amplitude2(float[][] items){
		return max(items) - min(items);
	}

	public static float max(float[][] items){
		float max = Float.NEGATIVE_INFINITY;

		for (float[] item : items){
			for (float f : item){
				if (f > max)
					max = f;
			}
		}
		return max;
	}

	public static float min(float[][] items){
		float min = Float.POSITIVE_INFINITY;

		for (float[] item : items){
			for (float f : item){
				if (f < min)
					min = f;
			}
		}
		return min;
	}

	@Override
	public boolean keyDown(int keycode){
		return false;
	}

	@Override
	public boolean keyUp(int keycode){
		return false;
	}

	@Override
	public boolean keyTyped(char character){
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button){
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button){
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer){
		this.camera.translate(-Gdx.input.getDeltaX(pointer) * camera.zoom, Gdx.input.getDeltaY(pointer) * camera.zoom);
		this.camera.update();
		return true;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY){
		return false;
	}

	@Override
	public boolean scrolled(int amount){
		this.camera.zoom += amount;
		this.camera.zoom = MathUtils.clamp(this.camera.zoom, 0.01F, 100);
		this.camera.update();
		return true;
	}

}
