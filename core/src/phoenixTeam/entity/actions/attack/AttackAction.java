package phoenixTeam.entity.actions.attack;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import phoenixTeam.component.ComponentMappers;
import phoenixTeam.component.TargeterComponent;
import phoenixTeam.entity.actions.Action;

public abstract class AttackAction implements Action {
	@Override
	public void doAction(Entity entity) {
		doSkillTargeted(entity, ComponentMappers.targeter.get(entity).target);
	}

	@Override
	public boolean check(Entity entity) {
		return Family.one(TargeterComponent.class).get().matches(entity);
	}

	public abstract void doSkillTargeted(Entity entity, Entity target);
}
