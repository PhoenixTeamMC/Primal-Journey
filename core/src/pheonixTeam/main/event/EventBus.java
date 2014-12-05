package pheonixTeam.main.event;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public class EventBus {
	
	private HashMap<Class<? extends Event>, ArrayList<Method>> listenerList;
	
	public EventBus(){
		 listenerList = new HashMap<Class<? extends Event>, ArrayList<Method>>();
	}
	
	public static void register(Object target){
		
		Class<?> clazz = target.getClass();
		
		for(Method method : clazz.getMethods()){
			
			if(method.isAnnotationPresent(Subscribe.class)){
				
				Class<?>[] parameters = method.getParameterTypes();
				
				if(parameters.length != 1){
					throw new RuntimeException("The method must have only one parameter.");
				}
				
				Class<?> parameter = parameters[0];
				
				if(!Event.class.isAssignableFrom(parameter)){
					throw new RuntimeException("The parameter is not a Event type");
				}
				
				
				
			}
			
		}
		
	}

}
