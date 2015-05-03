package phoenixTeam.screen;

import phoenixTeam.PrimalJourney;
import phoenixTeam.map.MapScreen;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class LoadingScreen extends ScreenAdapter{

	public LoadingScreen(){
		PrimalJourney.assetManager.load("data/pack/pack.atlas", TextureAtlas.class);
	}
	
	
	@Override
	public void render(float delta){
		if(PrimalJourney.assetManager.update()){
			PrimalJourney.INSTANCE.setScreen(new MapScreen());
		}
	}

	@Override
	public void show(){
		super.show();
	}

	@Override
	public void dispose(){
		super.dispose();
	}
	
	 

}
