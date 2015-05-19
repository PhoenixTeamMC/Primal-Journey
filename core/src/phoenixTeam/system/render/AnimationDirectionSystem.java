package phoenixTeam.system.render;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import phoenixTeam.component.ComponentMappers;
import phoenixTeam.component.movement.VelocityComponent;
import phoenixTeam.component.render.AnimationComponent;
import phoenixTeam.component.render.AnimationDirectionComponent;

public class AnimationDirectionSystem extends IteratingSystem{

	public AnimationDirectionSystem() {
		super(Family.all(AnimationDirectionComponent.class, AnimationComponent.class, VelocityComponent.class).get());
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime){
		AnimationComponent a = ComponentMappers.animation.get(entity);
		AnimationDirectionComponent d = ComponentMappers.animationDirection.get(entity);
		VelocityComponent v = ComponentMappers.velocity.get(entity);
		
		if(v.velocity.angle() < 135 && v.velocity.angle() > 45){
			//a.animation = d.up;
		}else if(v.velocity.angle() < 225){
			//a.animation = d.right;
		}else if(v.velocity.angle() < 315){
			//a.animation = d.down;
		}else{
			//a.animation = d.leftt;
		}
	}
	
	

}
