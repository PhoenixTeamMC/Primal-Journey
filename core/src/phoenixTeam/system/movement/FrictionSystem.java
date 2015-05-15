package phoenixTeam.system.movement;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.math.Vector2;
import phoenixTeam.component.ComponentMappers;
import phoenixTeam.component.movement.VelocityComponent;

public class FrictionSystem extends IteratingSystem{
	
	public FrictionSystem() {
		super(Family.all(VelocityComponent.class).get());
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		
		VelocityComponent velocity = ComponentMappers.velocity.get(entity);
		
		if(velocity.velocity.equals(Vector2.Zero)){
			return;
		}
		
		if(!velocity.isFrictonless){
			velocity.velocity.scl(.80F);
		}
	}

}
