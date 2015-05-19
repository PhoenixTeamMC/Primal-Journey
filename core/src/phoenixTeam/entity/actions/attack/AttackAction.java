package phoenixTeam.entity.actions.attack;

import com.badlogic.ashley.core.Entity;
import phoenixTeam.component.ComponentMappers;
import phoenixTeam.component.TargeterComponent;
import phoenixTeam.entity.actions.Action;
import phoenixTeam.util.IterableUtil;

public abstract class AttackAction implements Action {
	@Override
	public void doAction(Entity entity) {
		if (IterableUtil.containsInstance(entity.getComponents(), TargeterComponent.class)) {
			doSkillTargeted(entity, ComponentMappers.targeter.get(entity).target);
		}
	}

	public abstract void doSkillTargeted(Entity entity, Entity target);
}
