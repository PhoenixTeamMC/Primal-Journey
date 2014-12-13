package phoenixTeam.system;

import phoenixTeam.component.FamiliarComponent;
import phoenixTeam.component.PositionComponent;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;

public class FamiliarSystem extends IteratingSystem{
	
	private ComponentMapper<FamiliarComponent> f;
	
	@SuppressWarnings("unchecked")
	public FamiliarSystem(){
		super(Family.all(FamiliarComponent.class, PositionComponent.class).get());
		
		f = ComponentMapper.getFor(FamiliarComponent.class);
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		
	}
}
