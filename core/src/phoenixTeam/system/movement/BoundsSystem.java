package phoenixTeam.system.movement;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.math.MathUtils;
import phoenixTeam.component.ComponentMappers;
import phoenixTeam.component.movement.BoundingBoxComponent;
import phoenixTeam.component.movement.PositionComponent;
import phoenixTeam.map.MapScreen;

public class BoundsSystem extends IteratingSystem{

	@SuppressWarnings("unchecked")
	public BoundsSystem() {
		super(Family.all(BoundingBoxComponent.class, PositionComponent.class).get());
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime){
		BoundingBoxComponent c = ComponentMappers.boundingBox.get(entity);
		PositionComponent p = ComponentMappers.position.get(entity);
		
		p.x = MathUtils.clamp(p.x, 0, MapScreen.width - c.width);
		p.y = MathUtils.clamp(p.y, 0, MapScreen.height - c.height);
		
		
	}
	
	

}
