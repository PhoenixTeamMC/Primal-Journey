package phoenixTeam.system;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.ashley.utils.ImmutableArray;
import com.google.common.base.Optional;
import phoenixTeam.component.ComponentMappers;
import phoenixTeam.component.ItemComponent;
import phoenixTeam.item.Item;

/**
 * @author Strikingwolf
 */
public class ItemSystem extends IteratingSystem {

	@SuppressWarnings("unchecked")
	public ItemSystem() {
		super(Family.all(ItemComponent.class).get());
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		Optional<Item> itemO = ComponentMappers.item.get(entity).item;
		if (itemO.isPresent()) {
			Item item = itemO.get();
			Optional<ImmutableArray<Class<Component>>> components = (Optional<ImmutableArray<Class<Component>>>) item.getComponents();
			if (components.isPresent() && Family.all(components.get().toArray()).get().matches(entity)) {
				item.tick(entity);
			}
		}
	}
}