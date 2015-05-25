package phoenixTeam.map.simplex;

import phoenixTeam.PrimalJourney;
import phoenixTeam.map.HeightLayer;
import phoenixTeam.map.MapGenerator;
import phoenixTeam.util.Timer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class TestScreen implements Screen, InputProcessor{

	private Texture map;
	Pixmap pixmap;
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

		camera = new OrthographicCamera(1000, 1000 * (h / w)); // Setup Camera

		MapGenerator m = new MapGenerator(5000);

		m.addLayer(new HeightLayer());
		
		Timer.start("Creating Map");
		m.generate();  // Generate Map
		Timer.stop();

		Timer.start("Creating Picture of Map");

		pixmap = new Pixmap(m.size, m.size, Format.RGBA8888);

		for (int x = 0; x < m.size; x++){
			for (int y = 0; y < m.size; y++){
				pixmap.setColor(m.getColor(x, y));
				pixmap.drawRectangle(x, y, 1, 1);
			}
		}

		this.map = new Texture(pixmap);

		Timer.stop();
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
		pixmap.dispose();
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
		this.camera.zoom += amount / 4F;
		this.camera.zoom = MathUtils.clamp(this.camera.zoom, .25F, 100);
		this.camera.update();
		return true;
	}

}
