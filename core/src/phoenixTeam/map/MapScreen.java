package phoenixTeam.map;

import static phoenixTeam.PrimalJourney.engine;
import phoenixTeam.entity.EntityPlayer;
import phoenixTeam.system.AnimationSystem;
import phoenixTeam.system.LoadingSystem;
import phoenixTeam.system.PlayerSystem;
import phoenixTeam.system.RenderingSystem;

import com.badlogic.gdx.ScreenAdapter;

public class MapScreen extends ScreenAdapter{
	
	WorldMap map;
	
	public MapScreen(){

		map = new WorldMap(400, 400);
		
		engine.addSystem(new PlayerSystem());
		engine.addSystem(new RenderingSystem());
		engine.addSystem(new AnimationSystem());
		engine.addSystem(new LoadingSystem());
		
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
		map.map.dispose();
	}

}
