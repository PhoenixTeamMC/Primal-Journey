package phoenixTeam.system;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import phoenixTeam.component.PositionComponent;
import phoenixTeam.component.VelocityComponent;

public class VelocitySystem extends IteratingSystem{

	ComponentMapper<PositionComponent> p;
	ComponentMapper<VelocityComponent> v;
	
	public VelocitySystem() {
		super(Family.all(PositionComponent.class, VelocityComponent.class).get());
		
		p = ComponentMapper.getFor(PositionComponent.class);
		v = ComponentMapper.getFor(VelocityComponent.class);
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		
		PositionComponent pos = p.get(entity);
		VelocityComponent velocity = v.get(entity);
		
		pos.x += velocity.velocity.x;
		pos.y += velocity.velocity.y;
	}
	
	

}
