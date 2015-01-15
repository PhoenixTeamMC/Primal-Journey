package phoenixTeam.system;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import phoenixTeam.component.HealthComponent;

public class HealthSystem extends IteratingSystem{

	ComponentMapper<HealthComponent> h;
	
	Engine engine;
	
	@SuppressWarnings("unchecked")
	public HealthSystem() {
		super(Family.all(HealthComponent.class).get());
		
		h = ComponentMapper.getFor(HealthComponent.class);
	}

	@Override
	public void addedToEngine(Engine engine){
		super.addedToEngine(engine);
		this.engine = engine;
	}
	
	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		HealthComponent health = h.get(entity);
		
		if(health.health <= 0){
			engine.removeEntity(entity);
		}
	}

}
