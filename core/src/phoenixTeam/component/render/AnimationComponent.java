package phoenixTeam.component.render;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.utils.Array;
import phoenixTeam.util.specific.LoadableComponent;

public class AnimationComponent extends Component{
	
	public AnimationComponent(Animation animation){
		this.animation = animation;
	}
	
	public AnimationComponent(Animation animation, PlayMode mode){
		this.animation = animation;
		this.animation.setPlayMode(mode);
	}
	
	public Array<LoadableComponent<Animation>> toLoad = new Array<LoadableComponent<Animation>>(false, 4);
	
	public Animation animation;
}
