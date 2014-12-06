package phoenixTeam.event;

import java.lang.reflect.Method;
import java.util.List;

import phoenixTeam.event.EventBus.EventListener;

/**
 * Abstract Event Class, handles calling of all Interested methods.
 * @author CBachman
 *
 */
public abstract class Event {
	
	
	
	public void callEvent(){
		List<EventListener<Object, Method>> list =  EventBus.INSTANCE.listenerList.get(getClass());
		
		if(list == null || list.isEmpty()){
			return;
		}
		
		for(EventListener<Object, Method> listener: list){
			listener.invoke(this);
		}
		
	}
	
	

}
