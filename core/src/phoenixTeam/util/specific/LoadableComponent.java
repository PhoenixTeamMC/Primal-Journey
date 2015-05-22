package phoenixTeam.util.specific;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.g2d.Animation;
import phoenixTeam.util.specific.AnimationLoader.AnimationParameters;

import static phoenixTeam.PrimalJourney.assetManager;

public class LoadableComponent<T>{
	
	T toLoad;
	String location;
	
	public LoadableComponent(String location, Class<?> type){
		this.location = location;
		
		assetManager.load(location, type);
	}
	
	public LoadableComponent(String location, Class<Animation> type, int columns, int rows){
		assetManager.load(new AssetDescriptor(location, type, new AnimationParameters(rows, columns)));
	}
	
	public T get(){
		return toLoad;
	}

}
