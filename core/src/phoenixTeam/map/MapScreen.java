package phoenixTeam.map;

import phoenixTeam.Main;
import phoenixTeam.component.PlayerComponent;
import phoenixTeam.component.PositionComponent;
import phoenixTeam.component.RenderComponent;
import phoenixTeam.system.PlayerSystem;
import phoenixTeam.system.RenderingSystem;
import phoenixTeam.util.TextureUtil;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class MapScreen extends ScreenAdapter{
	
	public Engine engine;
	
	public OrthographicCamera camera;
	
	Map map;
	
	public MapScreen(){
		engine = new Engine();

		//Setup the camera
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		camera = new OrthographicCamera(100, 100 * (h/w));
		camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);    
		camera.update(); 

		map = new Map(engine, 100, 100);
		
		engine.addSystem(new PlayerSystem(camera));
		engine.addSystem(new RenderingSystem(camera));
		
		engine.addEntity(spawnPlayer());
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		map.display(camera, Main.batch);
		engine.update(delta);
	}
	
	public Entity spawnPlayer(){
		Entity entity = new Entity();
		
		entity.add(new PositionComponent());
		entity.add(new PlayerComponent());
		entity.add(new RenderComponent(TextureUtil.getTexture("player.png")));
		
		return entity;
	}

}
