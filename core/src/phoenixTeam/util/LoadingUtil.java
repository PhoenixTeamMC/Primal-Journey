package phoenixTeam.util;

import static phoenixTeam.PrimalJourney.assetManager;

import java.util.HashMap;
import java.util.Map;

public class LoadingUtil{
	
	private static Map<String, Boolean> hasLoaded = new HashMap<String, Boolean>();
	
	public static boolean hasLoaded(Class<?> type, String... parameters){
		for(String a : parameters){
			if(!assetManager.isLoaded(a, type)){
				return false;
			}
		}
		
		return true;
	}
	
	public static <T> T load(String location, Class<T> type){
		
		if(location == null){
			return null;
		}
		
		Boolean hasStarted = hasLoaded.get(location);
		
		if(hasStarted == null){
			hasLoaded.put(location, false);
			hasStarted = false;
		}
		
		if(!hasStarted){
			assetManager.load(location, type);
			hasLoaded.put(location, true);
		}
		
		if(assetManager.isLoaded(location)){
			return assetManager.get(location, type);
		}
		
		return null;
	}

}
