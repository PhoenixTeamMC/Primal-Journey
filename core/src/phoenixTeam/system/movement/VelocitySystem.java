package phoenixTeam.system.movement;

import phoenixTeam.component.ComponentMappers;
import phoenixTeam.component.movement.PositionComponent;
import phoenixTeam.component.movement.VelocityComponent;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;

public class VelocitySystem extends IteratingSystem{
	
	public VelocitySystem() {
		super(Family.all(PositionComponent.class, VelocityComponent.class).get());
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		
		PositionComponent pos = ComponentMappers.position.get(entity);
		VelocityComponent velocity = ComponentMappers.velocity.get(entity);
		
		pos.x += velocity.velocity.x;
		pos.y += velocity.velocity.y;
	}
	
	

}
