package phoenixTeam.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;

/**
 * @author Strikingwolf
 */
public abstract class KillableComponent extends Component {
	public abstract boolean die(Entity entity);

	public abstract void afterDeath(Entity entity);
}
