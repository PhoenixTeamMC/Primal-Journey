package phoenixTeam.entity;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;

/**
 * Ok, so. This is my solution to the individual behaviour. Subclasses should use this to declare thier components, and implement the interfaces that let them react to certain events. 
 * @author CBachman
 *
 */
public abstract class EntityBase extends Entity {
	
	public EntityBase(Component... components){
		
		List<Component> list = new ArrayList<Component>();
		
		registerComponents(list);
		
		for(Component c : list){
			this.add(c);
		}
	}
	
	public abstract void registerComponents(List<Component> list);
	
	
	
	

}
