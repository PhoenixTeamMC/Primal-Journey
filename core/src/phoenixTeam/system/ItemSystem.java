package phoenixTeam.system;

import phoenixTeam.component.ComponentMappers;
import phoenixTeam.component.ItemComponent;
import phoenixTeam.item.Item;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;

/**
 * @author Strikingwolf
 */
public class ItemSystem extends IteratingSystem{

	@SuppressWarnings("unchecked")
	public ItemSystem() {
		super(Family.all(ItemComponent.class).get());
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime){
		Item item = ComponentMappers.item.get(entity).item;
		
		if (item.getFamily().matches(entity)){
			item.tick(entity);
		}
	}
}