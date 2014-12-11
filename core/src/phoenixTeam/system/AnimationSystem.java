package phoenixTeam.system;

import phoenixTeam.component.AnimationComponent;
import phoenixTeam.component.RenderComponent;
import phoenixTeam.component.StateComponent;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.g2d.Animation;

public class AnimationSystem extends IteratingSystem{
	
	private ComponentMapper<AnimationComponent> a;
	private ComponentMapper<RenderComponent> r;
	private ComponentMapper<StateComponent> s;
	
	
	@SuppressWarnings("unchecked")
	public AnimationSystem(){
		super(Family.all(RenderComponent.class, AnimationComponent.class, StateComponent.class).get());
		
		a = ComponentMapper.getFor(AnimationComponent.class);
		r = ComponentMapper.getFor(RenderComponent.class);
		s = ComponentMapper.getFor(StateComponent.class);
	}
	
	public void processEntity(Entity entity, float deltaTime) {
        AnimationComponent anim = a.get(entity);
        RenderComponent texture = r.get(entity);
        StateComponent state = s.get(entity);
        
        Animation animation = anim.animation;
        
        if(animation != null){
        	texture.region = animation.getKeyFrame(state.state);
        }
        
        state.state += deltaTime;
    }

}
