package phoenixTeam.map;

import static phoenixTeam.PrimalJourney.engine;
import phoenixTeam.entity.EntityPlayer;
import phoenixTeam.system.PlayerSystem;
import phoenixTeam.system.movement.BoundsSystem;
import phoenixTeam.system.movement.ControlSystem;
import phoenixTeam.system.movement.FrictionSystem;
import phoenixTeam.system.movement.VelocitySystem;
import phoenixTeam.system.render.AnimationSystem;
import phoenixTeam.system.render.LoadingSystem;
import phoenixTeam.system.render.RenderingSystem;

import com.badlogic.gdx.ScreenAdapter;

public class MapScreen extends ScreenAdapter{
	
	WorldMap map;
	
	public static int width = 400;
	public static int height = 400;
	
	public MapScreen(){

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
