package phoenixTeam.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import phoenixTeam.PrimalJourney;
import phoenixTeam.event.entity.AfterDeath;
import phoenixTeam.event.entity.Death;

/**
 * @author Strikingwolf
 */
public class KillableComponent extends Component {
	public int deathCount = 0;

	public boolean die(Entity entity) {
		Death death = new Death(entity);
		PrimalJourney.bus.post(death);
		if (death.cancelled()) {
			deathCount++;
			return true;
		}
		return false;
	}

	public void afterDeath(Entity entity) {
		PrimalJourney.bus.post(new AfterDeath(entity));
	}
}
