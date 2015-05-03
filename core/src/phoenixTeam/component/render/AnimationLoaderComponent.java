package phoenixTeam.component.render;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;

public class AnimationLoaderComponent extends Component {

	public String toLoad;
	public boolean hasStarted;
	public PlayMode mode;
	
	public AnimationLoaderComponent(String toLoad, PlayMode mode) {
		this.toLoad = toLoad;
		this.mode = mode;
	}
	
	

}
