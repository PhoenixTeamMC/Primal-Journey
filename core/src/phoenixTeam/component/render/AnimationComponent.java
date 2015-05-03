package phoenixTeam.component.render;


import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;

public class AnimationComponent extends Component{
	
	public AnimationComponent(Animation animation){
		this.animation = animation;
	}
	
	public AnimationComponent(Animation animation, PlayMode mode){
		this.animation = animation;
		this.animation.setPlayMode(mode);
	}
	
	public Animation animation;
}
