package phoenixTeam.entity.actions.hidden;

import com.badlogic.ashley.core.Entity;
import phoenixTeam.entity.actions.Action;

public interface HiddenAction extends Action {
	public boolean willUnlock(Entity entity);
}
