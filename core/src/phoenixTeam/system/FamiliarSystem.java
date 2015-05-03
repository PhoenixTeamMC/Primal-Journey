package phoenixTeam.system;

import phoenixTeam.component.FamiliarComponent;
import phoenixTeam.component.movement.PositionComponent;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;

public class FamiliarSystem extends IteratingSystem{
	
	@SuppressWarnings("unchecked")
	public FamiliarSystem(){
		super(Family.all(FamiliarComponent.class, PositionComponent.class).get());
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		
	}
}
