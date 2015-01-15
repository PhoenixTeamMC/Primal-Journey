package phoenixTeam.map;

import phoenixTeam.PrimalJourney;
import phoenixTeam.component.AnimationComponent;
import phoenixTeam.component.PlayerComponent;
import phoenixTeam.component.PositionComponent;
import phoenixTeam.component.RenderComponent;
import phoenixTeam.component.StateComponent;
import phoenixTeam.system.AnimationSystem;
import phoenixTeam.system.PlayerSystem;
import phoenixTeam.system.RenderingSystem;
import phoenixTeam.util.TextureUtil;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;

public class MapScreen extends ScreenAdapter{
	
	public Engine engine;
	
	public OrthographicCamera camera;
	
	WorldMap map;
	
	public MapScreen(){
		engine = new Engine();

		//Setup the camera
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		camera = new OrthographicCamera(100, 100 * (h/w));
		camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);    
		camera.update(); 

		map = new WorldMap(engine, 64, 64);
		
		engine.addSystem(new PlayerSystem(camera));
		engine.addSystem(new RenderingSystem(camera));
		engine.addSystem(new AnimationSystem());
		
		engine.addEntity(spawnPlayer());
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		map.display(camera, PrimalJourney.batch);
		engine.update(delta);
	}
	
	public Entity spawnPlayer(){
		Entity entity = new Entity();
		
		entity.add(new PositionComponent());
		entity.add(new PlayerComponent());
		entity.add(new RenderComponent(TextureUtil.getTexture("ba.gif"), 6, 6));
		entity.add(new StateComponent());
		
		AnimationComponent component = new AnimationComponent();
		
		PrimalJourney.manager.load("data/ba.gif", Animation.class);
		
		PrimalJourney.manager.finishLoading();
		
		component.animation = PrimalJourney.manager.get("data/ba.gif");
		component.animation.setPlayMode(PlayMode.LOOP);
		entity.add(component);
		
		return entity;
	}
	
	@Override
	public void hide() {
		this.dispose();
	}

	@Override
	public void dispose(){
		map.map.dispose();
	}

}
