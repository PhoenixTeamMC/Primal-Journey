package phoenixTeam.system;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import phoenixTeam.PrimalJourney;
import phoenixTeam.component.ComponentMappers;
import phoenixTeam.component.HealthComponent;

public class HealthSystem extends IteratingSystem{
	
	@SuppressWarnings("unchecked")
	public HealthSystem() {
		super(Family.all(HealthComponent.class).get());
	}
	
	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		HealthComponent health = ComponentMappers.health.get(entity);
		
		if(health.health <= 0){
			PrimalJourney.engine.removeEntity(entity);
		}
	}

}
