package phoenixTeam.map;

import static phoenixTeam.PrimalJourney.assetManager;
import static phoenixTeam.PrimalJourney.engine;
import phoenixTeam.PrimalJourney;
import phoenixTeam.system.PlayerSystem;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;

public class MapScreen extends ScreenAdapter{
	
	WorldMap map;
	public static final int scaling = 4;
	
	public static int width = 128;
	public static int height = 128;
	
	Texture toDisplay;
	
	public MapScreen(){

		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		PrimalJourney.camera.viewportWidth = 10;
		PrimalJourney.camera.viewportHeight = 10 * (h/w);
		
		//FileHandle handle = Gdx.files.local("worldMap.json");
		
		//if(!handle.exists()){
			//map = new WorldMap(width, height);
		//}else{
		//	map = PrimalJourney.json.fromJson(WorldMap.class, handle);
		//}
		
		MapGenerator g = new MapGenerator();
		
		engine.addSystem(new PlayerSystem());
		//engine.addSystem(new RenderingSystem());
		//engine.addSystem(new AnimationSystem());
		//engine.addSystem(new BoundsSystem());
		//engine.addSystem(new ControlSystem());
		//engine.addSystem(new VelocitySystem());
		//engine.addSystem(new FrictionSystem());
		//engine.addSystem(new AnimationDirectionSystem());
		
		//engine.addEntity(new EntityPlayer());
		
		
		
	}

	@Override
	public void render(float delta) {
		//map.display();
		assetManager.update();
		PrimalJourney.batch.begin();
		PrimalJourney.batch.draw(toDisplay, 0, 0, 10, 10);
		PrimalJourney.batch.end();
	}
	
	@Override
	public void hide() {
		this.dispose();
	}

	@Override
	public void dispose(){
		
		//PrimalJourney.json.toJson(map, WorldMap.class, Gdx.files.local("worldMap.json"));
		//map.map.dispose();
	}

}
