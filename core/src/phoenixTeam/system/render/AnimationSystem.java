package phoenixTeam.system.render;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.g2d.Animation;
import phoenixTeam.component.ComponentMappers;
import phoenixTeam.component.StateComponent;
import phoenixTeam.component.render.AnimationComponent;
import phoenixTeam.component.render.RenderComponent;

public class AnimationSystem extends IteratingSystem{
	
	
	@SuppressWarnings("unchecked")
	public AnimationSystem(){
		super(Family.all(RenderComponent.class, AnimationComponent.class, StateComponent.class).get());
	}
	
	@Override
	public void processEntity(Entity entity, float deltaTime) {
        AnimationComponent anim = ComponentMappers.animation.get(entity);
        
        RenderComponent texture = ComponentMappers.render.get(entity);
        StateComponent state = ComponentMappers.state.get(entity);
        
        Animation animation = anim.animation;
        
        texture.region = animation.getKeyFrame(state.state);
        
        state.state += deltaTime; 
    }

}
