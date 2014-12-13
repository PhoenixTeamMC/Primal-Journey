package phoenixTeam.map;

import phoenixTeam.Main;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class MapScreen extends ScreenAdapter{
	
	public Engine engine;
	
	public OrthographicCamera camera;
	
	Map map;
	
	public MapScreen(){
		engine = new Engine();
		
		camera = new OrthographicCamera();
		
		map = new Map(engine, 100, 100);
	}
	
	@Override
	public void render(float delta) {
		
		map.display(camera, Main.batch);
	}

}
