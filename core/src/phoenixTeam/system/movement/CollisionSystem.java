package phoenixTeam.system.movement;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import phoenixTeam.component.movement.BoundingBoxComponent;

public class CollisionSystem extends IteratingSystem{

	public CollisionSystem() {
		super(Family.all(BoundingBoxComponent.class).get());
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		
	}
	
}
