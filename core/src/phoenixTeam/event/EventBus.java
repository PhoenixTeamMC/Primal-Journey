package phoenixTeam.event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EventBus {
	
	public static final EventBus INSTANCE = new EventBus();
	
	HashMap<Class<? extends Event>, List<EventListener<Object,Method>>> listenerList;
	
	private EventBus(){
		 listenerList = new HashMap<Class<? extends Event>, List<EventListener<Object,Method>>>();
	}
	
	public void register(Object target){
		
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
				
				@SuppressWarnings("unchecked")
				Class<? extends Event> eventClass = (Class<? extends Event>) parameter;
				
				List<EventListener<Object, Method>> eventListenerList = listenerList.get(eventClass); 
				
				if(eventListenerList == null){
					eventListenerList = new ArrayList<EventListener<Object, Method>>();
					eventListenerList.add(new EventListener<Object, Method>(target, method));
					listenerList.put(eventClass, eventListenerList);
					return;
				}
				
				eventListenerList.add(new EventListener<Object, Method>(target, method));
			}
			
		}
		
	}
	
	public static class EventListener<E, M>{
		
		public final Object o;
		public final Method m;
		
		public EventListener(Object o, Method m){
			this.o = o;
			this.m = m;
		}
		
		public Object getObj(){
			return o;
		}
		
		public Method getMethod(){
			return m;
		}
		
		public void invoke(Event event){
			try {
				this.m.invoke(o, event);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
	}

}
