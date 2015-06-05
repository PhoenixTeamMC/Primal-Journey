package phoenixTeam.event.entity;

import com.badlogic.ashley.core.Entity;
import phoenixTeam.event.SignalBase;

/**
 * @author Strikingwolf
 */
public class AfterDeath extends EntityEvent {
	public static final SignalBase<AfterDeath> signal = new SignalBase<AfterDeath>();

	public AfterDeath(Entity entity) {
		super(entity);
	}
}
