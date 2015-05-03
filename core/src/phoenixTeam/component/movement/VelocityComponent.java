package phoenixTeam.component.movement;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;

public class VelocityComponent extends Component {
	
	//public float velocity;
	//public float angle;
	
	public Vector2 velocity = Vector2.Zero.cpy();
	
	public boolean isFrictonless = false;

}
