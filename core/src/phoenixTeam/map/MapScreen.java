package phoenixTeam.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import phoenixTeam.PrimalJourney;
import phoenixTeam.entity.EntityPlayer;
import phoenixTeam.system.PlayerSystem;
import phoenixTeam.system.movement.BoundsSystem;
import phoenixTeam.system.movement.ControlSystem;
import phoenixTeam.system.movement.FrictionSystem;
import phoenixTeam.system.movement.VelocitySystem;
import phoenixTeam.system.render.AnimationSystem;
import phoenixTeam.system.render.LoadingSystem;
import phoenixTeam.system.render.RenderingSystem;

import static phoenixTeam.PrimalJourney.engine;

public class MapScreen extends ScreenAdapter{
	
	WorldMap map;
	public static final int scaling = 4;
	
	public static int width = 128;
	public static int height = 128;
	
	
	public MapScreen(){

		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		PrimalJourney.camera.viewportWidth = 10;
		PrimalJourney.camera.viewportHeight = 10 * (h/w);
		
		//FileHandle handle = Gdx.files.local("worldMap.json");
		
		//if(!handle.exists()){
			map = new WorldMap(width, height);
		//}else{
		//	map = PrimalJourney.json.fromJson(WorldMap.class, handle);
		//}
		
		
		
		engine.addSystem(new PlayerSystem());
		engine.addSystem(new RenderingSystem());
		engine.addSystem(new AnimationSystem());
		engine.addSystem(new LoadingSystem());
		engine.addSystem(new BoundsSystem());
		engine.addSystem(new ControlSystem());
		engine.addSystem(new VelocitySystem());
		engine.addSystem(new FrictionSystem());
		
		engine.addEntity(new EntityPlayer());
		
	}

	@Override
	public void render(float delta) {
		map.display();
		
	}
	
	@Override
	public void hide() {
		this.dispose();
	}

	@Override
	public void dispose(){
		
		//PrimalJourney.json.toJson(map, WorldMap.class, Gdx.files.local("worldMap.json"));
		map.map.dispose();
	}

}
