package phoenixTeam.system;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import phoenixTeam.component.BoundingBoxComponent;

public class CollisionSystem extends IteratingSystem{

	public CollisionSystem() {
		super(Family.all(BoundingBoxComponent.class).get());
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		
	}
	
}
