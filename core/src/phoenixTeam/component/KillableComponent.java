package phoenixTeam.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import phoenixTeam.event.SignalBase;
import phoenixTeam.event.entity.AfterDeath;
import phoenixTeam.event.entity.Death;

/**
 * @author Strikingwolf
 */
public class KillableComponent extends Component {
	public boolean die(Entity entity) {
		return (new SignalBase<Death>().dispatchWithResult(new Death(entity))).cancelled();
	}

	public void afterDeath(Entity entity) {
		new SignalBase<AfterDeath>().dispatch(new AfterDeath(entity));
	}
}
