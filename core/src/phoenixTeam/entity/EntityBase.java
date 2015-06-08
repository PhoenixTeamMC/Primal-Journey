package phoenixTeam.entity;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.utils.Array;

/**
 * Ok, so. This is my solution to the individual behaviour. Subclasses should use this to declare thier components, and implement the interfaces that let them react to certain events. 
 * @author CBachman
 *
 */
public abstract class EntityBase extends Entity {
	
	public EntityBase(Component... components){
		
		Array<Component> list = new Array<Component>();
		
		registerComponents(list);
		
		for(Component c : list){
			this.add(c);
		}
	}
	
	public abstract void registerComponents(Array<Component> list);
}
